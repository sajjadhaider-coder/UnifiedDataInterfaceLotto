package com.data.UnifiedLottoDataInterface.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Timestamp;

public class UserInfoRequest {

    @NotNull
    @Column(name = "NICKNAME", nullable = false)
    private String nickname;

    @NotNull
    @Column(name = "ACCOUNT_NUMBER", unique = true, nullable = false, length = 20)
    @JsonIgnore // Hide sensitive data if necessary
    private String username;

    @NotNull
    @Column(name = "VERIFICATION_CODE", length = 10)
    private String verificationCode;

    @NotNull
    @JsonIgnore // Prevent password from being serialized
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "CREATED_AT")
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    private Timestamp updatedAt;

    @Column(name = "UPDATED_BY")
    private int updatedBy;

    @Column(name = "BALANCE")
    private int balance;

    @Column(name = "STATUS")
    private String status;

}
