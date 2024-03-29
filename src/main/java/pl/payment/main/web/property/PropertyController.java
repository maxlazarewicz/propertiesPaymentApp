package pl.payment.main.web.property;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.payment.main.domain.models.property.Property;
import pl.payment.main.domain.service.property.PropertyService;
@Slf4j
@RestController
@RequestMapping("/property")
@CrossOrigin(origins = {"http://localhost:8082"}, allowedHeaders = "*")
@AllArgsConstructor
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("/list")
    @PreAuthorize("permitAll")
    public ResponseEntity getProperty() {
        return new ResponseEntity(propertyService.getAllProperty(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll")
    public ResponseEntity getPropertyById(@PathVariable Long id) {
        return new ResponseEntity((propertyService.getPropertyById(id)), HttpStatus.OK);
    }
    @PostMapping("/add")
    @PreAuthorize("permitAll")
    public ResponseEntity addProperty(@RequestBody Property property){
        return new ResponseEntity(propertyService.addProperty(property), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    @PreAuthorize("permitAll")
    public ResponseEntity updatePropertyById(@PathVariable Long id, @RequestBody Property property){
        propertyService.updateProperty(id, property);
        return new ResponseEntity( HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("permitAll")
    public ResponseEntity deleteProperty(@PathVariable Long id){
        propertyService.deleteProperty(id);
        return new ResponseEntity("Property with id " + id + " has deleted succesfull. ", HttpStatus.OK);
    }


}
