package com.data.UnifiedLottoDataInterface.dto;

import lombok.Data;

@Data
public class BallGameResultRequest {

    String currentDrawNumber;
    String gameName;
    String nextDrawNumber;
    String ballNumbers;
    String drawDataTime;

}
