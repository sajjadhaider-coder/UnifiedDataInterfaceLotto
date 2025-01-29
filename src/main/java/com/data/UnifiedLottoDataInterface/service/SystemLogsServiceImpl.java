package com.data.UnifiedLottoDataInterface.service;

import com.data.UnifiedLottoDataInterface.dto.SystemLogsRequest;
import com.data.UnifiedLottoDataInterface.dto.SystemLogsResponse;
import com.data.UnifiedLottoDataInterface.model.SystemLogs;
import com.data.UnifiedLottoDataInterface.repository.SystemLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SystemLogsServiceImpl implements SystemLogsService {

    private final SystemLogsRepository systemLogsRepository;

    @Autowired
    public SystemLogsServiceImpl(SystemLogsRepository systemLogsRepository) {
        this.systemLogsRepository = systemLogsRepository;
    }
    @Override
    public SystemLogsResponse saveLogRecord(SystemLogsRequest slr) {
        SystemLogs systemLogs = null;
        SystemLogsResponse systemLogsResponse = null;

        if (slr != null) {
            systemLogs = new SystemLogs(slr.getAccessTime(), slr.getAccessStatus(), slr.getServerUrl(), slr.getErrorText(), slr.getStatusCode() );
            systemLogs = systemLogsRepository.save(systemLogs);
            if (systemLogs.getId() > 0) {
                systemLogsResponse = new SystemLogsResponse(systemLogs.getAccessTime(), systemLogs.getAccessStatus(), systemLogs.getServerUrl(), systemLogs.getErrorText(), systemLogs.getStatusCode());
            }
        }
        return systemLogsResponse;
    }

    @Override
    public List<SystemLogsResponse> getLogs() {
        List<SystemLogsResponse> slrList = null;
        try {
            List<SystemLogs>  systemLogsList = systemLogsRepository.findAll();
            slrList = new ArrayList<>();
            SystemLogsResponse slr = null;
            for (SystemLogs systemLogs : systemLogsList) {
                slr = new SystemLogsResponse(systemLogs.getAccessTime(), systemLogs.getAccessStatus(), systemLogs.getServerUrl(), systemLogs.getErrorText(), systemLogs.getStatusCode());
                slrList.add(slr);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return slrList;
    }
}
