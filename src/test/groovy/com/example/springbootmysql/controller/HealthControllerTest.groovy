package com.example.springbootmysql.controller

import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

class HealthControllerTest extends Specification {

    def "health"() {
        given:
        def target = new HealthController()
        def mockMvc = MockMvcBuilders.standaloneSetup(target).build()

        when:
        def response = mockMvc.perform(get("/health"))

        then:
        def actual = response.andReturn().getResponse().getContentAsString()
        assert actual == "OK"
    }
}
