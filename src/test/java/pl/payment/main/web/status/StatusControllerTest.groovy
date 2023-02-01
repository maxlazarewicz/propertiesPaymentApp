package pl.payment.main.web.status

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
import pl.payment.main.domain.models.status.LeadStatus
import spock.lang.Shared
import spock.lang.Specification

@AutoConfigureMockMvc(addFilters = false)
@EnableJpaRepositories(basePackages = "pl.payment.main.domain.*")
@EntityScan(basePackages = "pl.payment.main.domain.*")
@EnableWebMvc
@SpringBootTest
class StatusControllerTest extends Specification {

    @Autowired
    MockMvc mvc;

    @Shared
    ObjectMapper objectMapper;

    def setupSpec() {
        objectMapper = new ObjectMapper();
    }

    def 'Should Return List of Status'(){
        when:
        def response = mvc.perform(MockMvcRequestBuilders.get("/leadstatus/list")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
        List statuses = Arrays.asList(objectMapper.readValue(response.getContentAsString(), LeadStatus[].class))
        statuses.get(0).getId() == 1
        statuses.get(0).getName() == "Nowy"
        statuses.get(0).getFull_name() == "Nowy"
    }

    def 'Should return Status and Http 200'(){
        when:
        def response = mvc.perform(MockMvcRequestBuilders.get("/leadstatus/1")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
        LeadStatus status = objectMapper.readValue(response.getContentAsString(), LeadStatus.class)
        status.getId() == 1
        status.getName() == "Nowy"
        status.getFull_name() == "Nowy"
    }

    def 'Should Delete Status and Http200'(){

        when:
        def response = mvc.perform(MockMvcRequestBuilders.delete("/leadstatus/delete/2")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
    }

}
