package pl.payment.main.domain.repository.lead;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.payment.main.domain.models.lead.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

}
