package hasanalmunawrDev.springbootjwtauth.service;

import hasanalmunawrDev.springbootjwtauth.Repository.UserRepo;
import hasanalmunawrDev.springbootjwtauth.dto.request.SignInRequest;
import hasanalmunawrDev.springbootjwtauth.dto.request.SignUpRequest;
import hasanalmunawrDev.springbootjwtauth.dto.response.SignInResponse;
import hasanalmunawrDev.springbootjwtauth.dto.response.SignUpResponse;
import hasanalmunawrDev.springbootjwtauth.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        log.info("[AuthService:signUp] Creating request : {}", signUpRequest.getUsername());
        var user = new UserEntity();
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setCreatedAt(new Date());

        userRepo.save(user);
        log.info("[AuthService:signUp] Created request : {}", signUpRequest.getUsername());


        return SignUpResponse.builder()
                .username(signUpRequest.getUsername())
                .email(signUpRequest.getEmail())
                .createdAt(new Date())
                .build();
    }

    public UserEntity signIn(SignInRequest signInRequest) {
        log.info("[AuthService:signIn] Loading request : {}", signInRequest.getEmail());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getEmail(),
                        signInRequest.getPassword()
                )
        );

        return userRepo.findByEmail(signInRequest.getEmail()).orElseThrow();

    }
}
