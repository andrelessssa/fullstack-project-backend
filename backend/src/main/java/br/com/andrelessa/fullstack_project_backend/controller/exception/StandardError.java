package br.com.andrelessa.fullstack_project_backend.controller.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
        super();
    }

    public StandardError(Long timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    

    

}
// campos do postman
//"timestamp": "2025-10-29T09:16:42.996+00:00",
//    "status": 500,
//    "error": "Internal Server Error",
//    "trace"