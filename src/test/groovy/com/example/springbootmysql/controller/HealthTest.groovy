package com.example.springbootmysql.controller

import spock.lang.Specification

class HealthTest extends Specification {
    def "getHealth" () {
        given:
        def target = new Health()
        when:
        def response = target.getHealth()
        then:
        assert response == "OK"
    }
}
