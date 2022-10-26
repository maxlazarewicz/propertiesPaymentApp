package pl.payment.main.domain.service.lead;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.payment.main.domain.models.lead.Lead;
import pl.payment.main.domain.repository.lead.LeadRepository;
import pl.payment.main.domain.utils.Commons;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class LeadService extends Commons {

    @Autowired
    LeadRepository leadRepository;

    @Transactional
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Transactional
    public Lead getLeadById(Long id) {
        return leadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lead with id " + id + " not found. "));
    }

    @Transactional
    public Lead addLead(Lead lead) {
        lead.setOwner(getPrincipal());

        return leadRepository.saveAndFlush(lead);
    }

    @Transactional
    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }
}
