package pl.payment.main.domain.service.user;

import jdk.jshell.spi.ExecutionControl;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.payment.main.domain.models.property.Property;
import pl.payment.main.domain.models.users.Users;
import pl.payment.main.domain.repository.user.UserRepository;
import pl.payment.main.infrastructure.config.errorcode.ErrorCode;
import pl.payment.main.infrastructure.config.exceptions.UserException;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

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

    @SneakyThrows
    @Transactional
    public Users getUserById(Long id) {
        return userRepository.findById(id).
                orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND_MESSAGE, Map.ofEntries(Map.entry("Id",id),Map.entry("Id1",id))));
    }

    @Transactional
    public Users addUser(Users user) {
        return userRepository.saveAndFlush(user);
    }

    @Transactional
    public void updateUser(Long id, Users users) {
        Users oldUser = getUserById(id);
        oldUser.setUsername(users.getUsername());
        oldUser.setFirstName(users.getFirstName());
        oldUser.setLastName(users.getLastName());
        oldUser.setEmail(users.getEmail());
        oldUser.setPassword(users.getPassword());
        addUser(oldUser);
    }
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
