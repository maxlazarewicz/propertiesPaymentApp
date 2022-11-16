package pl.payment.main.web.lead;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.payment.main.domain.client.filedata.FileData;
import pl.payment.main.domain.models.lead.Lead;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLeadPayload {

    Lead lead;
    List<FileData> fileDataList;
}
