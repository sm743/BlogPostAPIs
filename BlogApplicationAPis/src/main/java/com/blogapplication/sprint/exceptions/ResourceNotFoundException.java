package com.blogapplication.sprint.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourcename;
    private String fieldName;
    private String fieldValue;

    public ResourceNotFoundException(String resourcename, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s and %s",resourcename,fieldName,fieldValue));
        this.resourcename = resourcename;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourcename() {
        return resourcename;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }
}
