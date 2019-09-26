package com.huang.Bean;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessageBean {

    private static final String Fail_Code = "100";
    private static final String success_Code = "200";
    private static final String Fail_MESSAGE = "请求处理失败！";
    private static final String success_MESSAGE = "请求处理成功！";

    private String responseStatus;
    private String responseMessage;
    private Map<String,Object> responseData =new HashMap<>();

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Map<String, Object> getResponseData() {
        return responseData;
    }

    public void setResponseData(Map<String, Object> responseData) {
        this.responseData = responseData;
    }

    public ResponseMessageBean(String responseStatus, String responseMessage) {
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
    }

    public static ResponseMessageBean Handlefailure(){
        return new ResponseMessageBean(Fail_Code,Fail_MESSAGE);
    }

    public static ResponseMessageBean Handlesuccess(){
        return new ResponseMessageBean(success_Code,success_MESSAGE);
    }

    public ResponseMessageBean addresponseData(String key,Object data){
        this.responseData.put(key,data);
        return this;
    }
}
