package pl.payment.main.domain.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.payment.main.domain.models.users.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}


