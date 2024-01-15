package com.payment.core.exception.enums;

public enum ErrorCode {
    ON0001("Invalid Tax Number!", "ON-0001"),
    TR0001("Shopkeepers can only receive transfers!", "TR-0001"),
    TR0002("Insufficient balance!", "TR-0002"),
    TR0003("Invalid Transaction Pin!", "TR-0003");

    private String message;
    private String code;

    ErrorCode(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
