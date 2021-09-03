package com.apiProxy.exception;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
public class ServerException extends RuntimeException {
    public ServerException(String msg) {
        super(msg);
    }

    public ServerException(Throwable cause) {
        super(cause);
    }
}
