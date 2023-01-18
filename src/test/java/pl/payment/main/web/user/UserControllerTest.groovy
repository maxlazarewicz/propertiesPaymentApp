package pl.payment.main.web.property.user

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import pl.payment.main.domain.models.users.Users
import pl.payment.main.domain.repository.user.UserRepository
import pl.payment.main.domain.service.user.UserService
import pl.payment.main.infrastructure.config.TestConfig
import pl.payment.main.web.user.UserController
import spock.lang.Shared
import spock.lang.Specification
import org.springframework.http.HttpStatus

@AutoConfigureMockMvc(addFilters = false)
@EnableJpaRepositories(basePackages = "pl.payment.main.domain.*")
@EntityScan(basePackages = "pl.payment.main.domain.*")
@EnableWebMvc
@SpringBootTest(classes =
[
        UserController.class,
        UserService.class,
        UserRepository.class,
        TestConfig.class
] )

class UserControllerTest extends Specification {

    @Autowired
    MockMvc mvc;

    @Shared
    ObjectMapper objectMapper;

    def setupSpec() {
        objectMapper = new ObjectMapper();
    }

    def 'Should return list of users and Http 200'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.get("/user/list")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()
        List users = Arrays.asList(objectMapper.readValue(response.getContentAsString(), Users[].class))
        users.get(0).getId() == 1
        users.get(0).getUsername() == "mx_94"
        users.get(0).getEmail() == "mxlazarewicz@gmail.com"
        users.get(0).getFirstName() == "Maks"
        users.get(0).getLastName() == "Lazarewicz"
        users.get(0).getPassword() == "pass123"
        users.get(0).getPhoneNumber() == "509411644"
    }

    def 'Should return user and HTTP 200'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.get("/user/1")).andReturn().response

        then:
        response != null
        response.status == HttpStatus.OK.value()

        Users users = objectMapper.readValue(response.getContentAsString(), Users.class)
        users.getId() == 1
        users.getUsername() == "mx_94"
        users.getEmail() == "mxlazarewicz@gmail.com"
        users.getFirstName() == "Maks"
        users.getLastName() == "Lazarewicz"
        users.getPassword() == "pass123"
        users.getPhoneNumber() == "509411644"
    }

    def 'Should change user and return 200'() {
        when:
        def response = mvc.perform(MockMvcRequestBuilders.put("/user/update/2").
                contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(getValidUser())))
                .andReturn().response
        then:
        response.status == HttpStatus.OK.value()
    }

    def 'Should delete user and Http 200'(){
        when:
        def response=mvc.perform(MockMvcRequestBuilders.delete("/user/delete/1")).andReturn().response

        then:
        response!= null
        response.status == HttpStatus.OK.value()
    }

    def getValidUser() {
        return Users.builder()
                .id(3)
                .username("Jurek")
                .email("wp@wp.pl")
                .firstName("Jerzy")
                .lastName("Koperek")
                .phoneNumber("509411644")
                .password("pll122")
                .build()
    }

}
