package id.go.kemenkeu.siku.services.accounts;

import id.go.kemenkeu.siku.models.accounts.Role;
import id.go.kemenkeu.siku.models.accounts.User;
import id.go.kemenkeu.siku.models.repositories.RoleRepository;
import id.go.kemenkeu.siku.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder pEncoder;

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role getRolePeserta() {
        return roleRepository.findById(2L).get();
    }

    @Override
    public int countByEmail(String email) {
        return userRepository.countByEmail(email);
    }

    @Override
    public User getByActivationToken(String token) {
        Optional<User> userOptional = userRepository.findByActivationToken(token);
        if (!userOptional.isPresent()) {
            throw new RuntimeException();
        }
        return userOptional.get();
    }

    @Override
    public User activate(User user) {
        user.setStatus(1)
                .setActive(true);
        return userRepository.save(user);
    }



    @Override
    public User getById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }else{
            throw new RuntimeException();
        }
    }
}
