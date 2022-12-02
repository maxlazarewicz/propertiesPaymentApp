package pl.payment.main.web.property

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import pl.payment.main.domain.models.property.Property
import pl.payment.main.domain.repository.property.PropertyRepository
import pl.payment.main.domain.service.property.PropertyService
import pl.payment.main.infrastructure.config.TestConfig
import spock.lang.Shared
import spock.lang.Specification

@AutoConfigureMockMvc(addFilters = false)
@EnableJpaRepositories(basePackages = "pl.payment.main.domain.*")
@EntityScan(basePackages = "pl.payment.main.domain.*")
@EnableWebMvc
@SpringBootTest(classes =
        [
                PropertyController.class,
                PropertyService.class,
                PropertyRepository.class,
                TestConfig.class
        ])
class PropertyControllerTest extends Specification {

    @Autowired
    MockMvc mvc;

    @Shared
    ObjectMapper objectMapper;

    //Wykonuje sie za kazdym jednym pojedynczym tescie
    def setupSpec() {
        objectMapper = new ObjectMapper();
    }

    def 'Should return list of property and HTTP 200'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.get("/property/list")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
//        and:
//////        with(objectMapper.readValue(response.contentAsString, Map)){
//////
//////        }
    }
    def 'Should change property and return 200'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.put("/property/2").
                contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(getValidProperty())))
                .andReturn().response
        then:
        response.status == HttpStatus.OK.value()
    }

    def 'Should add property and Http 201'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.post("/property/add").
                contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(getValidProperty())))
                .andReturn().response
        then:
        response.status == HttpStatus.CREATED.value()
    }

    def getValidProperty() {
        return Property.builder()
                .id(2)
                .postal_code("66-666")
                .city("Wawa")
                .house_number(7)
                .province("gg")
                .street("rwrsf")
                .apartment_number(5)
                .build()
    }
}
