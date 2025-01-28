package com.data.UnifiedLottoDataInterface.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BallGameResultResponse {

    String currentDrawNumber;
    String gameName;
    String nextDrawNumber;
    String ballNumbers;
    String drawDataTime;

}
