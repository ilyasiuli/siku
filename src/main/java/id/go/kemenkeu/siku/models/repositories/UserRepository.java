package id.go.kemenkeu.siku.models.repositories;

import id.go.kemenkeu.siku.models.accounts.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    int countByEmail(String email);

    Optional<User> findByActivationToken(String token);
}