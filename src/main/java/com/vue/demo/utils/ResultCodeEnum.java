package com.vue.demo.utils;

/**
 * @author yangwj
 * @date 2020/3/22 16:59
 */
public enum ResultCodeEnum {
    SUCCESS(true,200,"成功"),
    UNKNOWN_ERROR(false,401,"未知参数"),
    PARAM_ERROR(false,402,"参数错误"),
    UPLOAD_FILE_ERROR(false,10000,"上传文件失败！"),
    USERNAME_PASSWORD_ERROR(false,10001,"用户名密码错误"),
    OCR_ERROR(false,10002,"tesseract解析错误！"),
    OCR_LANGUAGE_ERROR(false,10003,"语言参数错误");

    private Boolean success;
    private Integer code;
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
