package com.data.UnifiedLottoDataInterface.repository;

import com.data.UnifiedLottoDataInterface.dto.BallGameResultResponse;
import com.data.UnifiedLottoDataInterface.model.BallGameResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BallGameResultRepository extends JpaRepository<BallGameResult, Long> {


    @Query(value = "SELECT * FROM Austria_lucky_ball_results WHERE game_name = :name", nativeQuery = true)
    List<BallGameResult> getResultList(@Param("name") String name);
}
