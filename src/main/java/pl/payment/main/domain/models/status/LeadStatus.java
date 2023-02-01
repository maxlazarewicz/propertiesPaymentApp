package pl.payment.main.domain.models.status;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.payment.main.domain.models.lead.Lead;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lead_status")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeadStatus {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leadStatus", orphanRemoval = true)
    @JsonIgnore
    private List<Lead> statusList = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String full_name;

}
