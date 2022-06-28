package id.go.kemenkeu.siku.models.repositories;

import id.go.kemenkeu.siku.models.accounts.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}