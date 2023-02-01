package pl.payment.main.web.lead

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import pl.payment.main.domain.models.lead.Lead
import spock.lang.Shared
import spock.lang.Specification

@AutoConfigureMockMvc(addFilters = false)
@EnableJpaRepositories(basePackages = "pl.payment.main.domain.*")
@EntityScan(basePackages = "pl.payment.main.domain.*")
@EnableWebMvc
@SpringBootTest

class LeadControllerTest extends Specification {

    @Autowired
    MockMvc mvc;

    @Shared
    ObjectMapper objectMapper;

    def setupSpec() {
        objectMapper = new ObjectMapper();
    }

    def 'Should return list of Lead and HTTP 200'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.get("/lead/list")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
        List lead = Arrays.asList(objectMapper.readValue(response.getContentAsString(), Lead[].class))
        lead.get(0).getId() == 1
        lead.get(0).getCreationDate().toString() == "Wed Oct 26 18:31:08 CEST 2022"
        lead.get(0).getEndingDate() == null
        lead.get(0).getAdministrativeRent() == "333"
        lead.get(0).getElectricityPayment() == "123"
        lead.get(0).getWaterPayment() == "222"
        lead.get(0).getLeadStatus().getId() == 1
        lead.get(0).getProperty().getId() == 1
        lead.get(0).getOwner() == "owner"
        lead.get(0).getTenant() == "tenant"
    }

    def 'Should return Lead and HTTP 200'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.get("/lead/1")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
        Lead lead = objectMapper.readValue(response.getContentAsString(), Lead.class)
        lead.getId() == 1
        lead.getCreationDate().toString() == 'Wed Oct 26 18:31:08 CEST 2022'
        lead.getEndingDate() == null
        lead.getAdministrativeRent() == "333"
        lead.getElectricityPayment() == "123"
        lead.getWaterPayment() == "222"
        lead.getLeadStatus().getId() == 1
        lead.getProperty().getId() == 1
        lead.getOwner() == "owner"
        lead.getTenant() == "tenant"
    }
    def 'Should delete Lead and HTTP 200'(){
        when:
        def response = mvc.perform(MockMvcRequestBuilders.delete("/lead/delete/1")).andReturn().response

        then:
        response!=null
        response.status == HttpStatus.OK.value()
    }
}
