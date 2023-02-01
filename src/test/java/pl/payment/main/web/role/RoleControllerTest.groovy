package pl.payment.main.web.role

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
import pl.payment.main.domain.enums.ERole
import pl.payment.main.domain.models.roles.Roles
import spock.lang.Shared
import spock.lang.Specification
@AutoConfigureMockMvc(addFilters = false)
@EnableJpaRepositories(basePackages = "pl.payment.main.domain.*" )
@EntityScan(basePackages = "pl.payment.main.domain.*" )
@EnableWebMvc
@SpringBootTest
class RoleControllerTest extends Specification{

    @Autowired
    MockMvc mvc;

    @Shared
    ObjectMapper objectMapper;

    def setupSpec() {
        objectMapper = new ObjectMapper();
    }

    def 'Should return list of property and HTTP 200' (){
        when:
        def response = mvc.perform(MockMvcRequestBuilders.get("/role/list")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
        List roles = Arrays.asList(objectMapper.readValue(response.getContentAsString(), Roles[].class))
        roles.get(0).getId() == 1
        roles.get(0).getName() == ERole.ROLE_ADMIN
        roles.get(0).getTranslatedName() == "Admin"
    }

    def "Should return Role and HTTP 200" (){
        when:
        def response = mvc.perform(MockMvcRequestBuilders.get("/role/1")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
        Roles role = objectMapper.readValue(response.getContentAsString(), Roles.class)
        role.getId() == 1
        role.getName() == ERole.ROLE_ADMIN
        role.getTranslatedName() == "Admin"
    }

    def 'Should delete Role and HTTP200' () {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.delete("/role/delete/1")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
    }
}
