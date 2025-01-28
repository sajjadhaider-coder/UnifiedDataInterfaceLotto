package com.data.UnifiedLottoDataInterface.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Timestamp;

public class UserInfoResponse {
    private String nickname;
    private String username;
    private String verificationCode;
    private String password;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int updatedBy;
    private int balance;
    private String status;

}
