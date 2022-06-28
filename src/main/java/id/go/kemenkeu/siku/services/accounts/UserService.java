package id.go.kemenkeu.siku.services.accounts;

import id.go.kemenkeu.siku.models.accounts.Role;
import id.go.kemenkeu.siku.models.accounts.User;

public interface UserService {
    User getById(Long id);
    User getByUsername(String username);

    Role getRolePeserta();

    int countByEmail(String email);

    User getByActivationToken(String token);

    User activate(User user);
}
