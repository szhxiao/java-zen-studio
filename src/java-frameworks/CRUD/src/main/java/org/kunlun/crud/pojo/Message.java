/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud.pojo;


import java.util.HashMap;
import java.util.Map;

public class Message {
    // 状态码
    private int code;
    // 提示信息
    private String message;
    // 用户返回给浏览器的数据
    private Map<String, Object> extend = new HashMap<>();

    public Message() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public static Message success() {
        Message result = new Message();
        result.setCode(100);
        result.setMessage("Notes: operate successfully");
        return result;
    }

    public static Message fail() {
        Message result = new Message();
        result.setCode(200);
        result.setMessage("Notes: operate fail");
        return result;
    }

    public Message add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }
}

