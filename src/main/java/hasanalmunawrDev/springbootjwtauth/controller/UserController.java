package hasanalmunawrDev.springbootjwtauth.controller;

import hasanalmunawrDev.springbootjwtauth.dto.response.SignUpResponse;
import hasanalmunawrDev.springbootjwtauth.entity.UserEntity;
import hasanalmunawrDev.springbootjwtauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/current-user")
    public ResponseEntity<?> whoAmI() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        var user = (UserEntity)authentication.getPrincipal();

       return ResponseEntity.ok(
               SignUpResponse.builder()
                       .username(user.getUsername())
                       .email(user.getEmail())
                       .createdAt(user.getCreatedAt())
                       .build()
       );
    }

    @GetMapping("/all")
    public ResponseEntity<?> allUser() {
        List<UserEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
