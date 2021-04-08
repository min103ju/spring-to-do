package com.security.todo.service;

import com.security.todo.model.UserInfo;
import com.security.todo.model.UserInfoDto;
import com.security.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Spring Security 필수 메소드 구현
     * @param email
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserInfo loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public Long save(UserInfoDto userInfoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userInfoDto.setPassword(encoder.encode(userInfoDto.getPassword()));

        return userRepository.save(
                UserInfo.builder()
                        .email(userInfoDto.getEmail())
                        .auth(userInfoDto.getAuth())
                        .password(userInfoDto.getPassword()).build()).getPkey();
    }
}
