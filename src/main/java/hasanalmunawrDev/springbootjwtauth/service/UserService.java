package hasanalmunawrDev.springbootjwtauth.service;

import hasanalmunawrDev.springbootjwtauth.Repository.UserRepo;
import hasanalmunawrDev.springbootjwtauth.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepository;

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users;
    }
}
