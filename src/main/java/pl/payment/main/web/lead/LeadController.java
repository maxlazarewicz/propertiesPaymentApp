package pl.payment.main.web.lead;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.payment.main.domain.models.lead.Lead;
import pl.payment.main.domain.service.lead.LeadService;
@Slf4j
@RestController
@RequestMapping("/lead")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class LeadController {

    @Autowired
    LeadService leadService;

    @GetMapping("/list")
    @PreAuthorize("permitAll")
    @Operation(summary = "Showing list of Leads")
    public ResponseEntity getLead() {
        return new ResponseEntity(leadService.getAllLeads(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll")
    @Operation(summary = "Showing lead by ID")
    public ResponseEntity getLeadById(@PathVariable Long id) {
        return new ResponseEntity((leadService.getLeadById(id)), HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("permitAll")
    public ResponseEntity addLead(@RequestBody AddLeadPayload addLeadPayload){
        return new ResponseEntity(leadService.addLead(addLeadPayload), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("permitAll")
    public ResponseEntity deleteLead(@PathVariable Long id ){
        leadService.deleteLead(id);
        return new ResponseEntity("Lead with id " + id + " has deleted successfull. ", HttpStatus.OK);
    }

}

