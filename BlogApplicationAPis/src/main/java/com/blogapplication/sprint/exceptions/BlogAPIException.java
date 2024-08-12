package com.blogapplication.sprint.exceptions;

public class BlogAPIException extends RuntimeException{
    private String resourcename;
    private String fieldName;
    private String fieldValue;

    public BlogAPIException(String resourcename, String fieldName, String fieldValue) {
        this.resourcename = resourcename;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public BlogAPIException(String message, String resourcename, String fieldName, String fieldValue) {
        super(message);
        this.resourcename = resourcename;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
