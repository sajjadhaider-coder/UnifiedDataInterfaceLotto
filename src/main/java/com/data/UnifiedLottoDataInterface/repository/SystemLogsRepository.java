package com.data.UnifiedLottoDataInterface.repository;

import com.data.UnifiedLottoDataInterface.model.SystemLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemLogsRepository extends JpaRepository<SystemLogs, Long> {
}
