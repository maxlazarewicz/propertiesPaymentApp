package pl.payment.main.domain.service.property;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.payment.main.domain.models.property.Property;
import pl.payment.main.domain.repository.property.PropertyRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    @Transactional
    public List<Property> getAllProperty(){return propertyRepository.findAll();}

    @Transactional
    public Property getPropertyById(Long id){
        return propertyRepository.findById(id).orElseThrow(()
    -> new EntityNotFoundException("Property with id:" + id + " not found."));
    }

    @Transactional
    public Property addProperty(Property property){return propertyRepository.saveAndFlush(property);}

    @Transactional
    public void deleteProperty(Long id){propertyRepository.deleteById(id);}

}
