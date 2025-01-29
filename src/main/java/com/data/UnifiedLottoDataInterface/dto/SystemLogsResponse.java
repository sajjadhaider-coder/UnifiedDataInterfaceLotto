package com.data.UnifiedLottoDataInterface.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemLogsResponse {

    private LocalDateTime accessTime;
    private String accessStatus;
    private String serverUrl;
    private String errorText;
    private String statusCode;

}