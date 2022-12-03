package vip.maosi.entity.response;

import com.alibaba.fastjson.JSON;

public class ResEntity<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public ResEntity<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResEntity<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResEntity<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
