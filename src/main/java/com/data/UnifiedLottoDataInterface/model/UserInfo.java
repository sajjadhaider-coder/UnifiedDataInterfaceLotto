package com.data.UnifiedLottoDataInterface.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Timestamp;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

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
