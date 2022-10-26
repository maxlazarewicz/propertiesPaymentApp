package pl.payment.main.domain.service.status;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.payment.main.domain.models.status.LeadStatus;
import pl.payment.main.domain.repository.status.LeadStatusRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class LeadStatusService {

    @Autowired
    LeadStatusRepository leadStatusRepository;

    @Transactional
    public List<LeadStatus> getAllStatus() {
        return leadStatusRepository.findAll();
    }

    @Transactional
    public LeadStatus getStatusById(Long id) {
        return leadStatusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role with id " + id + " not found"));
    }
    @Transactional
    public LeadStatus addStatus(LeadStatus leadStatus) {
        return leadStatusRepository.saveAndFlush(leadStatus);
    }

    @Transactional
    public void deleteStatus(Long id){
        leadStatusRepository.deleteById(id); }
}
