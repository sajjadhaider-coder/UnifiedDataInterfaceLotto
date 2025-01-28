package com.data.UnifiedLottoDataInterface.service;

import com.data.UnifiedLottoDataInterface.dto.BallGameResultRequest;
import com.data.UnifiedLottoDataInterface.dto.BallGameResultResponse;
import com.data.UnifiedLottoDataInterface.model.BallGameResult;

import java.util.List;

public interface BallGameResultService {

    BallGameResultResponse saveBallGameResult(BallGameResultRequest ballGameResult);
    List<BallGameResult> getResultList(String name);

}
