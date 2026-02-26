package org.example.bstagrambe.user;

import lombok.RequiredArgsConstructor;
import org.example.bstagrambe.user.model.User;
import org.example.bstagrambe.user.model.UserDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto.SignupRes signup (UserDto.SignupReq dto) {
        User user = dto.toEntity();
        userRepository.save(user);

        return UserDto.SignupRes.from(user);
    }
}
