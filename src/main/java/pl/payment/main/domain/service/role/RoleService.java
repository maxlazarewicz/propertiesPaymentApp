package pl.payment.main.domain.service.role;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.payment.main.domain.mail.MailService;
import pl.payment.main.domain.models.roles.Roles;
import pl.payment.main.domain.repository.role.RoleRepository;


import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    MailService mailService;

    @Transactional
    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    @Transactional
    public Roles getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role with id:" + id + " not found."));
    }

    @Transactional
    public Roles addRole(Roles role) {
        return roleRepository.saveAndFlush(role);
    }

    @Transactional
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
