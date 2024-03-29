package pl.payment.main.web.lead;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailLeadPayLoad {

    private long leadId;
    private String owner;
    private String tenant;
    private Date creationDate;
    private String electricityPayment;
    private String waterPayment;
    private String administrativeRent;

}
