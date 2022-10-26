package pl.payment.main.domain.repository.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.payment.main.domain.models.status.LeadStatus;

@Repository
public interface LeadStatusRepository extends JpaRepository<LeadStatus, Long> {



}
