package com.data.UnifiedLottoDataInterface.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Austria_lucky_ball_results")
public class BallGameResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "CURRENT_DRAW_NUMBER")
    String currentDrawNumber;

    @Column(name = "GAME_NAME")
    String gameName;

    @Column(name = "NEXT_DRAW_NUMBER")
    String nextDrawNumber;

    @Column(name = "BALL_NUMBERS")
    String ballNumbers;

    @Column(name = "DRAW_DATE_TIME")
    String drawDataTime;

    public BallGameResult(String currentDrawNumber, String gameName, String nextDrawNumber, String ballNumbers, String drawDataTime) {
        this.currentDrawNumber = currentDrawNumber;
        this.gameName = gameName;
        this.nextDrawNumber = nextDrawNumber;
        this.ballNumbers = ballNumbers;
        this.drawDataTime = drawDataTime;
    }
}
