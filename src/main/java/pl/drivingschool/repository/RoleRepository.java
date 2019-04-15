package pl.drivingschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.drivingschool.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
