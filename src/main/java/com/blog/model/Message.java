package com.blog.model;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private int code;
    private String msg;
    private Map<String, Object> map;

    public Message(){
        map = new HashMap<>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    /**
     * 处理成功时返回信息
     * @return message
     */
    public static Message success(){
        Message message = new Message();
        message.setCode(1);
        message.setMsg("处理成功");
        return message;
    }

    /**
     * 处理失败时返回信息
     * @return message
     */
    public static Message failed(){
        Message message = new Message();
        message.setCode(0);
        message.setMsg("处理失败");
        return message;
    }

    /**
     * 额外的返回信息
     * @return this
     */
    public Message add(String key, Object value){
        this.getMap().put(key, value);
        return this;
    }
}
