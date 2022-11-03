package pl.payment.main.domain.service.lead;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.payment.main.domain.client.FileDataClient;
import pl.payment.main.domain.models.lead.Lead;
import pl.payment.main.domain.repository.lead.LeadRepository;
import pl.payment.main.domain.service.filedata.FileDataService;
import pl.payment.main.domain.utils.Commons;
import pl.payment.main.web.lead.AddLeadPayload;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class LeadService extends Commons {

    @Autowired
    LeadRepository leadRepository;
    @Autowired
    FileDataService fileDataService;

    @Transactional
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Transactional
    public Lead getLeadById(Long id) {
        return leadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lead with id " + id + " not found. "));
    }

    @Transactional
    public Lead addLead(AddLeadPayload addLeadPayload) {
        addLeadPayload.getLead().setOwner(getPrincipal());
        fileDataService.addFilesFromList(addLeadPayload.getFileDataList());

        return leadRepository.saveAndFlush(addLeadPayload.getLead());
    }

    @Transactional
    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }

}
