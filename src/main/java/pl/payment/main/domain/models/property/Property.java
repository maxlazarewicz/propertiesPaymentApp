package pl.payment.main.domain.models.property;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "property")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Property {

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
