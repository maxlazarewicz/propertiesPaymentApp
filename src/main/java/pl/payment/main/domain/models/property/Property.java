package pl.payment.main.domain.models.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.payment.main.domain.models.lead.Lead;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "property")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Property {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "property", orphanRemoval = true)
    @JsonIgnore
    private List<Lead> propertyList = new ArrayList<>();
    @Id//primary key w tabeli
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private Integer house_number;

    private Integer apartment_number;

    private String postal_code;

    private String city;

    private String province;


}
