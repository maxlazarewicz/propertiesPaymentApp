package pl.payment.main.domain.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.payment.main.domain.models.roles.Roles;

import javax.management.relation.Role;


@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {


}
