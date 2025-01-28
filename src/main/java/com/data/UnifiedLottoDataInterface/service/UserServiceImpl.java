package com.data.UnifiedLottoDataInterface.service;

import com.data.UnifiedLottoDataInterface.dto.UserInfoRequest;
import com.data.UnifiedLottoDataInterface.dto.UserInfoResponse;
import com.data.UnifiedLottoDataInterface.model.UserInfo;
import com.data.UnifiedLottoDataInterface.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {


    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    public UserInfoResponse saveUser(UserInfoRequest userInfoRequest) {

        UserInfo ui = null;
        if (userInfoRequest != null) {

        }
        return null;
    }
}
