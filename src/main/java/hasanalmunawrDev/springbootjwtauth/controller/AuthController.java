package hasanalmunawrDev.springbootjwtauth.controller;

import hasanalmunawrDev.springbootjwtauth.dto.request.SignInRequest;
import hasanalmunawrDev.springbootjwtauth.dto.request.SignUpRequest;
import hasanalmunawrDev.springbootjwtauth.dto.response.SignInResponse;
import hasanalmunawrDev.springbootjwtauth.entity.UserEntity;
import hasanalmunawrDev.springbootjwtauth.service.AuthService;
import hasanalmunawrDev.springbootjwtauth.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    private final JwtService jwtService;

    @PostMapping(path = "/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {
        log.info("[AuthController:Signup] Sing up By : {}", signUpRequest.getUsername());
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest) {
        UserEntity userEntity = authService.signIn(signInRequest);

        String jwtToken = jwtService.generateToken(userEntity);

        SignInResponse response = new SignInResponse();
        response.setToken(jwtToken);
        response.setExpiresIn(jwtService.getJwtExpiration());

        return ResponseEntity.ok(response);
    }


}
