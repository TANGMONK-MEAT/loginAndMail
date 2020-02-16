package com.ml.pojo;

import java.io.Serializable;

/**
 * @author ZWL
 * @Auther:zwl
 * @Version: 1.0
 * @create: 2020/2/14 20:46
 *
 * 用于封装后端返回前端的数据对象
 */
public class ResultInfo implements Serializable {

    /**
     * 后端返回结果正常为true,发生异常返回false
     */
    private boolean flag = false;

    /**
     * 后端返回结果的数据对象
     */
    private Object data;

    /**
     * 发生异常的错误信息
     */
    private String errorMsg;

    public ResultInfo(){}

    public ResultInfo(boolean flag) {
        this.flag = flag;
    }

    public ResultInfo(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public ResultInfo(boolean flag, Object data, String errorMsg) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
