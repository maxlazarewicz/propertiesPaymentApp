package pl.payment.main.domain.models.lead;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import pl.payment.main.domain.models.property.Property;
import pl.payment.main.domain.models.status.LeadStatus;
import pl.payment.main.domain.models.users.Users;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Entity
@Table(name = "leads")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @DateTimeFormat
    private LocalDateTime creation_date;

    @DateTimeFormat
    //@UpdateTimestamp??? Tworzy w momencie update'a date w bazie danych w tym wypadku.
    private LocalDateTime ending_date;

    @ManyToOne(
            optional = false,
            targetEntity = Property.class
    )
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne(
            optional = false,
            targetEntity = LeadStatus.class
    )
    @JoinColumn(name = "lead_status_id")
    private LeadStatus leadStatus;

    private String owner;
    private String tenant;

    private String electricityPayment;
    private String waterPayment;
    private String administrativeRent;
}
