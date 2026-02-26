package org.example.bstagrambe.user;

import lombok.RequiredArgsConstructor;
import org.example.bstagrambe.user.model.AuthUserDetails;
import org.example.bstagrambe.user.model.User;
import org.example.bstagrambe.user.model.UserDto;
import org.example.bstagrambe.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserDto.SignupReq dto) {
        UserDto.SignupRes result = userService.signup(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDto.LoginReq dto) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword(), null);

        Authentication authentication = authenticationManager.authenticate(token);
        AuthUserDetails principal = (AuthUserDetails) authentication.getPrincipal();

        String jwt = jwtUtil.createToken(principal.getIdx(), principal.getUsername(), "ROLE_USER");

        User userEntity = userRepository.findById(principal.getIdx())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserDto.LoginRes body = UserDto.LoginRes.from(userEntity);

        return ResponseEntity.ok()
                .header("Set-Cookie", "ATOKEN=" + jwt + "; Path=/; HttpOnly; SameSite=Lax")
                .body(body);
    }
}
