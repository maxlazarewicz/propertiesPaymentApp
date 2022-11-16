package pl.payment.main.domain.service.lead;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.payment.main.domain.models.lead.Lead;
import pl.payment.main.domain.repository.lead.LeadRepository;
import pl.payment.main.domain.service.filedata.FileDataService;
import pl.payment.main.domain.service.mailsender.MailSenderService;
import pl.payment.main.domain.utils.Commons;
import pl.payment.main.web.lead.AddLeadPayload;
import pl.payment.main.web.lead.MailLeadPayLoad;

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
    @Autowired
    MailSenderService mailSenderService;

    @Transactional
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Transactional
    public Lead getLeadById(Long id) {
        return leadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lead with id " + id + " not found. "));
    }

    @Transactional(rollbackOn = Exception.class)
    public Lead addLead(AddLeadPayload addLeadPayload) {
        addLeadPayload.getLead().setOwner(getPrincipal());
        fileDataService.addFilesFromList(addLeadPayload.getFileDataList());

        Lead lead = leadRepository.saveAndFlush(addLeadPayload.getLead());

        mailSenderService.newLead(getMailLeadPayload(lead));

        return lead;
    }

    @Transactional
    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }

    @Transactional
    public void noPaymentProcess(Lead lead) {
        mailSenderService.noPayment(getMailLeadPayload(lead));
    }

    @Transactional
    public void paymentSuccessful(Lead lead) {
        mailSenderService.paid(getMailLeadPayload(lead));
    }

    private MailLeadPayLoad getMailLeadPayload(Lead lead) {
        return MailLeadPayLoad.builder()
                .leadId(lead.getId())
                .owner(lead.getOwner())
                .tenant(lead.getTenant())
                .administrativeRent(lead.getAdministrativeRent())
                .electricityPayment(lead.getElectricityPayment())
                .waterPayment(lead.getWaterPayment())
                .creationDate(lead.getCreation_date())
                .build();
    }
}
