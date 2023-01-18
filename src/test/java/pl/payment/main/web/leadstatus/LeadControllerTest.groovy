package pl.payment.main.web.property.leadstatus

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
import pl.payment.main.domain.models.status.LeadStatus
import pl.payment.main.domain.repository.status.LeadStatusRepository
import pl.payment.main.domain.service.status.LeadStatusService
import pl.payment.main.infrastructure.config.TestConfig
import pl.payment.main.web.lead.LeadController
import pl.payment.main.web.status.LeadStatusController
import spock.lang.Shared
import spock.lang.Specification

@AutoConfigureMockMvc(addFilters = false)
@EnableJpaRepositories(basePackages = "pl.payment.main.domain.*")
@EntityScan(basePackages = "pl.payment.main.domain.*")
@EnableWebMvc
@SpringBootTest(classes =
[
        LeadController.class,
        LeadStatusService.class,
        LeadStatusRepository.class,
        LeadStatus.class,
        TestConfig.class
] )

class LeadStatusControllerTest extends Specification {

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
        lead.get(0).getCreation_date() == "2022-10-26 18:31:08"
        lead.get(0).getEnding_date() == null
        lead.get(0).getAdministrativeRent() == "333"
        lead.get(0).getElectricityPayment() == "123"
        lead.get(0).getWaterPayment() == "222"
        lead.get(0).getLeadStatus() == 1
        lead.get(0).getProperty() == 1
        lead.get(0).getOwner() == "owner"
        lead.get(0).getTenant() == "tenant"

    }

}
