package com.data.UnifiedLottoDataInterface.controller;

import com.data.UnifiedLottoDataInterface.dto.BallGameResultResponse;
import com.data.UnifiedLottoDataInterface.model.BallGameResult;
import com.data.UnifiedLottoDataInterface.service.BallGameResultService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiInterfaces {

    @Autowired
    BallGameResultService ballGameResultService;
    @GetMapping("/lucky-ball-results/{name}")
    public List<BallGameResultResponse> getDrawResults( @PathVariable String name){
        List<BallGameResultResponse> bgrList = new ArrayList<>();
        try {
          List<BallGameResult> blist = ballGameResultService.getResultList(name);
          blist.forEach( r -> {
              bgrList.add(new BallGameResultResponse(r.getCurrentDrawNumber(), r.getGameName(), r.getNextDrawNumber(), r.getBallNumbers(), r.getDrawDataTime()));
          });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bgrList;
    }
}
