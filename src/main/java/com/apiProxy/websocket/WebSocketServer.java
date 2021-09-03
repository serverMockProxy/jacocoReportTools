package com.apiProxy.websocket;


import com.apiProxy.model.UploadFile;
import com.apiProxy.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.*;


/**
 * Created by jiangyitao.
 */
@Slf4j
@Component
@ServerEndpoint(value = "/socket/{project}")
public class WebSocketServer{

    protected RemoteEndpoint.Basic sender;
    @OnOpen
    public void onOpen(@PathParam("project") String project, Session session) throws Exception {
        sender = session.getBasicRemote();
    }

    @OnClose
    public void onClose() {
    }

    @OnError
    public void onError(Throwable t) {
        log.error("[{}]onError", t);
    }

    @OnMessage
    public void onMessage(@PathParam("project") String project,byte[] msg) throws IOException {
        saveExecFile(project,msg);
    }

    public void saveExecFile(String projectName,byte[] msg) throws IOException {
        File uploadProjectExecFileDir = new File("static/" + UploadFile.EXEC_PATH + "/" + projectName);
        if (!uploadProjectExecFileDir.exists()) {
            uploadProjectExecFileDir.mkdirs();
        }
        File execReadPath = new File(uploadProjectExecFileDir.getPath()+"/"+"ready");
        if (!execReadPath.exists()){
            execReadPath.mkdirs();
        }
        String fileName = uploadProjectExecFileDir.getPath() + "/" + UUIDUtil.getUUIDFilename(".exec");
        writeFileByBytes(fileName,msg,true);
    }

    private void writeFileByBytes(String fileName, byte[] bytes, boolean append) throws IOException {
        OutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(fileName, append));
            out.write(bytes);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
