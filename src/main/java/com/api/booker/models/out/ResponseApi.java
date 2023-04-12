package com.api.booker.models.out;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public class ResponseApi<T>{

    private T data;

    private int status;

    private String message;

    private boolean success;

    public ResponseApi(T data, int status, String message, boolean success) {
        this.data = data;
        this.status = status;
        this.message = message;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResponseApi{" +
                "data=" + data +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}

