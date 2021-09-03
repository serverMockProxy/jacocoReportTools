package com.apiProxy.utils;

import org.jacoco.report.IMultiReportOutput;

import java.io.*;
import java.util.*;

/**
 * @Author：hem
 * @Date：8/30/21 4:26 下午
 */
public class MemoryMultiReportOutput implements IMultiReportOutput {

    private final Map<String, ByteArrayOutputStream> files = new HashMap<String, ByteArrayOutputStream>();

    private final Set<String> open = new HashSet<String>();

    private boolean closed = false;

    public OutputStream createFile(final String path) throws IOException {
        open.add(path);
        final ByteArrayOutputStream out = new ByteArrayOutputStream() {
            @Override
            public void close() throws IOException {
                open.remove(path);
                super.close();
            }
        };
        files.put(path, out);
        return out;
    }

    public void close() throws IOException {
        closed = true;
    }

    public byte[] getFile(String path) {
        return files.get(path).toByteArray();
    }

    public InputStream getFileAsStream(String path) {
        return new ByteArrayInputStream(getFile(path));
    }

}

