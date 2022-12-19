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


    def setupSpec() {
        objectMapper = new ObjectMapper();
    }

    def 'Should return list of property and HTTP 200'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.get("/property/list")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
        List properties = Arrays.asList(objectMapper.readValue(response.getContentAsString(), Property[].class))
        properties.get(0).getId() == 1
        properties.get(0).getApartment_number() == 23
        properties.get(0).getCity() == "Warszawa"
        properties.get(0).getHouse_number() == 1
        properties.get(0).getPostal_code() == "61-222"
        properties.get(0).getProvince() == "Mazowieckie"
        properties.get(0).getStreet() == "Test1"

    }

    def 'Should return property and HTTP 200'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.get("/property/1")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
        Property properties = objectMapper.readValue(response.getContentAsString(), Property.class)
        properties.getId() == 1
        properties.getApartment_number() == 23
        properties.getCity() == "Warszawa"
        properties.getHouse_number() == 1
        properties.getPostal_code() == "61-222"
        properties.getProvince() == "Mazowieckie"
        properties.getStreet() == "Test1"
    }

    def 'Should change property and return 200'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.put("/property/update/1").
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

    def 'Should delete property and HTTP 200'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.delete("/property/delete/3")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
    }

    def getValidProperty() {
        return Property.builder()
                .id(4)
                .postal_code("66-666")
                .city("Wawa")
                .house_number(7)
                .province("gg")
                .street("rwrsf")
                .apartment_number(5)
                .build()
    }
}
