package pl.payment.main.web.role;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.payment.main.domain.models.roles.Roles;
import pl.payment.main.domain.service.role.RoleService;

@Slf4j
@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/list")
    @PreAuthorize("permitAll")
    public ResponseEntity getRoles() {
        return new ResponseEntity(roleService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("/role/{id}")
    @PreAuthorize("permitAll")
    public ResponseEntity getRoleById(@PathVariable Long id) {
        return new ResponseEntity(roleService.getRoleById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("permitAll")
    public ResponseEntity addRole(@RequestBody Roles roles) {
        return new ResponseEntity(roleService.addRole(roles), HttpStatus.OK);
    }

    @DeleteMapping("/role/{id}")
    @PreAuthorize("permitAll")
    public ResponseEntity deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);

        return new ResponseEntity("Role with id " + id + " has been deleted successfully.", HttpStatus.OK);
    }


}
