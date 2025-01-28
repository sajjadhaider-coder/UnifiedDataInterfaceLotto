package com.data.UnifiedLottoDataInterface.service;

import com.data.UnifiedLottoDataInterface.dto.BallGameResultRequest;
import com.data.UnifiedLottoDataInterface.dto.BallGameResultResponse;
import com.data.UnifiedLottoDataInterface.model.BallGameResult;
import com.data.UnifiedLottoDataInterface.repository.BallGameResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BallGameResultServiceImpl implements BallGameResultService {

    @Autowired
    BallGameResultRepository ballGameResultRepository;
    @Override
    public BallGameResultResponse saveBallGameResult(BallGameResultRequest bgrr) {

        BallGameResult ballGameResult = null;
        if( bgrr != null ) {
            ballGameResult = new BallGameResult( bgrr.getCurrentDrawNumber(), bgrr.getGameName(), bgrr.getNextDrawNumber(), bgrr.getBallNumbers(), bgrr.getDrawDataTime());
            ballGameResultRepository.save(ballGameResult);
        }
        return null;
    }

    @Override
    public List<BallGameResult> getResultList(String name) {
       return ballGameResultRepository.getResultList(name);
    }
}
