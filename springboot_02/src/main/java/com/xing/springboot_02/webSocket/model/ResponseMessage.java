package com.xing.springboot_02.webSocket.model;

/**
 * Created by 汪东兴 on 2016-12-4.
 */
public class ResponseMessage {

    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
