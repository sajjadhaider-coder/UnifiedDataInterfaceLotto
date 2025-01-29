package com.data.UnifiedLottoDataInterface.controller;


import com.data.UnifiedLottoDataInterface.dto.SystemLogsRequest;
import com.data.UnifiedLottoDataInterface.dto.SystemLogsResponse;
import com.data.UnifiedLottoDataInterface.repository.SystemLogsRepository;
import com.data.UnifiedLottoDataInterface.service.SystemLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class SystemLogController {

    @Autowired
    SystemLogsService systemLogsService;

    @GetMapping("/getLogs")
    public List<SystemLogsResponse> getSysLogs(){
        return systemLogsService.getLogs();
    }
}
