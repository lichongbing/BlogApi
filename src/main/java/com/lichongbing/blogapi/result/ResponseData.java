package com.lichongbing.blogapi.result;

/**
 * @author lichongbing
 * @version 1.0.0
 * @date 2021/5/10 4:52 下午
 * @description: 返回结果数据格式封装
 */
public class ResponseData extends Response {
    private Object data;

    public ResponseData(Object data) {
        this.data = data;
    }

    public ResponseData(ExceptionMsg msg) {
        super(msg);
    }

    public ResponseData(String rspCode, String rspMsg) {
        super(rspCode, rspMsg);
    }

    public ResponseData(String rspCode, String rspMsg, Object data) {
        super(rspCode, rspMsg);
        this.data = data;
    }


    public ResponseData(ExceptionMsg msg, Object data) {
        super(msg);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "data=" + data +
                "} " + super.toString();
    }
}

/*return new ResponseData(ExceptionMsg.SUCCESS,"你好");*/

