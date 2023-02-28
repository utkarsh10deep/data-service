package com.wings.dataservice.domain;

import lombok.Data;

@Data
public class Secrets {
    private String h2UserName;
    private String h2Password;
    private String serviceAuthenticationKey;
}
