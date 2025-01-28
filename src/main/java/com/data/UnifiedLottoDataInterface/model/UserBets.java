package com.data.UnifiedLottoDataInterface.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BETS")
public class UserBets {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BET_ID")
    private long id;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "LOTTERY_ID")
    private int lotteryId;

    @Column(name = "BET_TYPE")
    private String betType;

    @Column(name = "BET_NUMBER")
    private int betNumber;

    @Column(name = "BET_AMOUNT")
    private int betAmount;

    @Column(name = "CREATED_AT")
    private Timestamp createdAt;

    @Column(name = "RESULT")
    private String result;
}
