package com.data.UnifiedLottoDataInterface.repository;

import com.data.UnifiedLottoDataInterface.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

}
