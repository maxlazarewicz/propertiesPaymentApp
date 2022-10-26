package pl.payment.main.domain.repository.property;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.payment.main.domain.models.property.Property;

@Repository
    public interface PropertyRepository extends JpaRepository<Property, Long> {
}
