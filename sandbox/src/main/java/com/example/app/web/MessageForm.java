package com.example.app.web;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class MessageForm
{
    @NotBlank
    @Size(max = 10)
    private String message;

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
