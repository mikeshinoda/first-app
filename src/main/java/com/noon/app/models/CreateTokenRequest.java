package com.noon.app.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateTokenRequest {
    private String email;
    private String phone;
    @NotNull
    private String device_id;
    @NotNull
    private String platform;
}
