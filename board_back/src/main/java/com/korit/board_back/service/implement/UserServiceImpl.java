package com.korit.board_back.service.implement;

import com.korit.board_back.common.ResponseMessage;
import com.korit.board_back.dto.ResponseDto;
import com.korit.board_back.dto.user.request.UpdateUserRequestDto;
import com.korit.board_back.dto.user.response.UserResponseDto;
import com.korit.board_back.entity.User;
import com.korit.board_back.repository.UserRepository;
import com.korit.board_back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
/*
 Implement 축약어 : Impl
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public ResponseDto<UserResponseDto> getUserInfo(String userId) {
        UserResponseDto data = null;

        try {
            User user = userRepository.findByUserId(userId)
                    .orElse(null);
            if (user == null) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);
            }

            data = new UserResponseDto(user);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    @Override
    public ResponseDto<UserResponseDto> updateUser(String userId, UpdateUserRequestDto dto) {
        UserResponseDto data = null;
        String email = dto.getEmail();
        String name = dto.getName();
        String phone = dto.getPhone();

        try {
            User user = userRepository.findByUserId(userId)
                    .orElse(null);
            if (user == null) ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

//            user.setEmail(email);
//            user.setName(name);
//            user.setPhone(phone);

//            userRepository.save(user);
//            data = new UserResponseDto(user);

            user = user.toBuilder()
                    .email(email)
                    .name(name)
                    .phone(phone)
                    .build();


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    @Override
    public ResponseDto<Void> deleteUser(String userId) {

        ResponseDto<Void> data = null;

        try {
            User user = userRepository.findByUserId(userId)
                    .orElse(null);

            if (user == null) ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            userRepository.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, null);
    }

}
