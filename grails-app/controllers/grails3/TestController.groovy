package grails3

import grails.converters.JSON
import grails.transaction.Transactional
import groovy.sql.Sql

import javax.sql.DataSource

class TestController {
    def dataSource;
    def index() {
    }

    @Transactional
    def createDomain(){
        TestDomain testDomain = new TestDomain().save();
        render([id : testDomain.id] as JSON)
    }

    def getDomain() {
        assert TestDomain.get(params.id.asType(int)) != null
        render ""
    }

}
