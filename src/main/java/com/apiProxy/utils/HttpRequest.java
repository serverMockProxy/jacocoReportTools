package com.apiProxy.utils;

import com.apiProxy.exception.ServerException;
import com.apiProxy.model.dto.RequestInfo;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.xmlgraphics.util.WriterOutputStream;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.PrintStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @Author：hem
 * @Date：5/31/21 10:16 上午
 */
@Component
@Slf4j
public class HttpRequest {
    private StringWriter requestWriter;
    private PrintStream requestCapture;
    public HttpRequest(){
        this.requestWriter = new StringWriter();
        this.requestCapture = new PrintStream(new WriterOutputStream(requestWriter));
    }
    static {
        io.restassured.RestAssured.config = RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
                setParam("http.connection.timeout",30000).
                setParam("http.socket.timeout",30000).
                setParam("http.connection-manager.timeout",30000));
        io.restassured.RestAssured.defaultParser = Parser.JSON;
    }

    public Response doRequst(RequestInfo requestInfo){
        RequestSpecification requestSpecification = handleRequest(requestInfo);
        Response response = null;
        try {
            switch (requestInfo.getRequestType().toLowerCase()){
                case "get":
                    response = requestSpecification.get(requestInfo.getUrl());
                    break;
                case "post":
                    response = requestSpecification.post(requestInfo.getUrl());
                    break;
                case "put":
                    response = requestSpecification.put(requestInfo.getUrl());
                    break;
                case "delete":
                    response = requestSpecification.delete(requestInfo.getUrl());
                    break;
                default:
                    throw new ServerException("");
            }
        }catch (Exception e){
           log.error(e.getMessage());
        }
        log.info("请求参数：{}",requestWriter.toString());
        return response;
    }

    public RequestSpecification handleRequest(RequestInfo requestInfo){
        handleParams(requestInfo);
        RequestSpecification requestSpecification = given().filter(new RequestLoggingFilter(requestCapture)).headers(requestInfo.getRequestHeaders())
                .queryParams(requestInfo.getQueryBody())
                .formParams(requestInfo.getFormBody())
                .body(requestInfo.getJsonString())
                .when();
        return requestSpecification;
    }
    private void handleParams(RequestInfo requestInfo){
        if (null == requestInfo.getQueryBody()){
            requestInfo.setQueryBody(new HashMap());
        }
        if (null == requestInfo.getFormBody()){
            requestInfo.setFormBody(new HashMap());
        }
        if (StringUtils.isEmpty(requestInfo.getJsonString())){
            requestInfo.setJsonString("");
        }
    }
}
