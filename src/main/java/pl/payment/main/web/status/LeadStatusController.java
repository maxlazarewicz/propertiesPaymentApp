package pl.payment.main.web.status;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.payment.main.domain.client.filedata.FileData;
import pl.payment.main.domain.client.filedata.FileDataClient;
import pl.payment.main.domain.models.status.LeadStatus;
import pl.payment.main.domain.service.status.LeadStatusService;

@Slf4j
@RestController
@RequestMapping("/leadstatus")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class LeadStatusController {

    @Autowired
    FileDataClient fileDataClient;
    @Autowired
    LeadStatusService leadStatusService;

   @PostMapping("/addfiledata")
   @PreAuthorize("permitAll")
   public ResponseEntity addFileData(@RequestBody FileData fileData){
       return new ResponseEntity(fileDataClient.addFileData(fileData), HttpStatus.OK);
   }

    @GetMapping("/list")
    @PreAuthorize("permitAll")
    public ResponseEntity getLeadStatus(){
        return new ResponseEntity(leadStatusService.getAllStatus(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll")
    public ResponseEntity getLeadStatusById(@PathVariable Long id){
        return new ResponseEntity(leadStatusService.getStatusById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    @PreAuthorize("permitAll")
    public ResponseEntity addLeadStatus(@RequestBody LeadStatus leadStatus){
        return new ResponseEntity(leadStatusService.addStatus(leadStatus), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("permitAll")
    public ResponseEntity deleteLeadStatus(@PathVariable Long id){
        leadStatusService.deleteStatus(id);
        return new ResponseEntity("Status with id " + id + " has been deleted succesfully", HttpStatus.OK);
    }
}
