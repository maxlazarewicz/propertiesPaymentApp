package pl.payment.main.web.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.payment.main.domain.models.users.Users;
import pl.payment.main.domain.service.user.UserService;
@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    @PreAuthorize("permitAll")
    public ResponseEntity getUser() {
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("permitAll")
    public ResponseEntity getUserById(@PathVariable Long id) {
        return new ResponseEntity((userService.getUserById(id)), HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("permitAll")
    public ResponseEntity addUser(@RequestBody Users user) {
        return new ResponseEntity(userService.addUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("permitAll")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity("Role with id " + id + " has deleted succesfully.", HttpStatus.OK);
    }

}
