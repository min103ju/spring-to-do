package com.security.todo.service;

import com.security.todo.exception.CustomException;
import com.security.todo.exception.enums.ErrorEnum;
import com.security.todo.model.domain.UserInfo;
import com.security.todo.model.dto.UserInfoDto;
import com.security.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Spring Security 필수 메소드 구현
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserInfo loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findOneByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public Long save(UserInfoDto userInfoDto) throws CustomException {
        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));

        if(userRepository.findOneByEmail(userInfoDto.getEmail()).isPresent()){
            throw new CustomException(ErrorEnum.ERROR_USER_ALREADY_PRESENT);
        }

        return userRepository.save(
                UserInfo.builder()
                        .email(userInfoDto.getEmail())
                        .auth(userInfoDto.getAuth())
                        .password(userInfoDto.getPassword()).build()).getPkey();
    }
}
