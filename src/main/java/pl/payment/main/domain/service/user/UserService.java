package pl.payment.main.domain.service.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.payment.main.domain.models.users.Users;
import pl.payment.main.domain.repository.user.UserRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public Users getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id:" + id + " not found."));
    }

    @Transactional
    public Users addUser(Users user) {
        return userRepository.saveAndFlush(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
