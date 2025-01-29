package com.data.UnifiedLottoDataInterface.service;

import com.data.UnifiedLottoDataInterface.dto.SystemLogsRequest;
import com.data.UnifiedLottoDataInterface.dto.SystemLogsResponse;
import com.data.UnifiedLottoDataInterface.model.SystemLogs;

import java.util.List;
import java.util.Optional;

public interface SystemLogsService {
    SystemLogsResponse saveLogRecord(SystemLogsRequest systemLogs);
}
