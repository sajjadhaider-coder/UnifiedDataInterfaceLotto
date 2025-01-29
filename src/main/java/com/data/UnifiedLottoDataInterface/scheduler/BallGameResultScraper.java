package com.data.UnifiedLottoDataInterface.scheduler;

import com.data.UnifiedLottoDataInterface.dto.BallGameResultRequest;
import com.data.UnifiedLottoDataInterface.dto.SystemLogsRequest;
import com.data.UnifiedLottoDataInterface.model.SystemLogs;
import com.data.UnifiedLottoDataInterface.service.BallGameResultService;
import com.data.UnifiedLottoDataInterface.service.SystemLogsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class BallGameResultScraper implements   Runnable {

    @Value("${external.api.base-url_ball5}")
    private String apiBaseUrlBall5;

    @Value("${external.api.base-url_ball8}")
    private String apiBaseUrlBall8;

    @Value("${external.api.base-url_ball10}")
    private String apiBaseUrlBall10;

    @Value("${external.api.base-url_ball20}")
    private String apiBaseUrlBall20;
    @Autowired
    BallGameResultService ballGameResultService;

    @Autowired
    SystemLogsService systemLogsService;
     public enum  gamenames {
        LUCKYBALL5, LUCKYBALL8, LUCKYBALL10, LUCKYBALL20
    }
    @Override
    public void run(){
        HttpResponse<String> response = null;

        SystemLogsRequest  systemLogs = null;
        ArrayList<String> urls = new ArrayList<>();
        urls.add(apiBaseUrlBall5);
        urls.add(apiBaseUrlBall8);
        urls.add(apiBaseUrlBall10);
        urls.add(apiBaseUrlBall20);

        BallGameResultRequest bgr = null;
        for( int i = 0; i < urls.size(); i++ ) {
            try {
                systemLogs = new SystemLogsRequest();
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(urls.get(i)))
                        .GET()
                        .build();
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
                systemLogs.setStatusCode(String.valueOf(response.statusCode()));
                if (response.statusCode() == 200) {
                    Document document = Jsoup.parse(response.body());
                    bgr = new BallGameResultRequest();

                    if (urls.get(i).contains("ball8.php")) {
                        bgr.setGameName(String.valueOf(gamenames.LUCKYBALL8));
                    } else if (urls.get(i).contains("ball5.php")) {
                        bgr.setGameName(String.valueOf(gamenames.LUCKYBALL5));
                    } else if (urls.get(i).contains("ball10.php")) {
                        bgr.setGameName(String.valueOf(gamenames.LUCKYBALL10));
                    } else if (urls.get(i).contains("ball20.php")) {
                        bgr.setGameName(String.valueOf(gamenames.LUCKYBALL20));
                    }
                    // Extract date and time
                    String drawDateTime = document.select("div.brt2f_1").text();
                    bgr.setDrawDataTime(drawDateTime);

                    // Extract current draw number
                    String currentDrawNumber = document.select("div.brt2f_2 span").text();
                    bgr.setCurrentDrawNumber(currentDrawNumber);

                    // Extract all ball numbers
                    Elements ballNumbers = document.select("div.brt2_ball > div");
                    StringBuilder sb = new StringBuilder();
                    for (Element ball : ballNumbers) {
                        sb.append(" " + ball.text());
                    }
                    bgr.setBallNumbers(sb.toString());

                    // Extract next draw number
                    String nextDrawNumber = document.select("div.brt3t_number span").text();
                    bgr.setNextDrawNumber(nextDrawNumber);

                    ballGameResultService.saveBallGameResult(bgr);
                    systemLogs.setAccessStatus("SUCCESS");
                } else {
                    systemLogs.setAccessStatus("FAILED");
                    systemLogs.setErrorText(response.body());
                }
                systemLogs.setAccessTime(LocalDateTime.now());
                systemLogs.setServerUrl(urls.get(i));
            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                systemLogs.setErrorText(sw.toString()); // Saves full stack trace in DB
            }

            finally {
                systemLogsService.saveLogRecord(systemLogs);
            }
        }
    }
}
