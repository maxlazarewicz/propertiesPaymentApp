package pl.payment.main.web.errorcodeinfo;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.payment.main.domain.service.errorcodeinfo.ErrorCodeInfoService;

@Slf4j
@RestController
@RequestMapping("/info")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class ErrorCodeInfoController {

    @Autowired
    ErrorCodeInfoService errorCodeInfoService;

    @GetMapping("/list")
    @PreAuthorize("permitAll")
    @Operation(summary = "Showing list of Leads")
    public ResponseEntity getAllErrors() {
        return new ResponseEntity(errorCodeInfoService.getAllErrors(), HttpStatus.OK);
    }
}
