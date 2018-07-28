package com.beannote.beannote.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.web.bind.annotation.ResponseBody;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseData<Data> {
    public static final int SUCCESS = 200;

    private int code;
    private String msg;
    private Data data;

    public int getCode() {
        return code;
    }

    public ResponseData setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Data getData() {
        return data;
    }

    public ResponseData<Data> setData(Data data) {
        this.data = data;
        return this;
    }

    public ResponseData(int code, Data data) {
        this.code = code;
        this.data = data;
    }

    public ResponseData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <Data> ResponseData<Data> createSuccess(Data data){
        return new ResponseData<>(SUCCESS,data);
    }

    public static ResponseData createSuccessWithMsg(String msg){
        return new ResponseData(SUCCESS,msg);
    }

    public static ResponseData createErrorWithMsg(String msg){
        return new ResponseData(-1,msg);
    }
}
