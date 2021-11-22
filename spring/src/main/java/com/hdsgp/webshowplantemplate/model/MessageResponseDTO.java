package com.hdsgp.webshowplantemplate.model;

public class MessageResponseDTO {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageResponseDTO(String message) {
        this.message = message;
    }

    public MessageResponseDTO() {
    }

    @Override
    public String toString() {
        return "MessageResponseDTO{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
