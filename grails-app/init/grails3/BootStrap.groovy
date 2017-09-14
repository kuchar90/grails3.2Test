package grails3

import groovy.sql.Sql

class BootStrap {
    def dataSource;
    def init = { servletContext ->
        if(TestDomain.count < 1000000){
            print "Insert 1000000 records..."
            Sql sql = new Sql(dataSource: dataSource);

            //postgres
//            sql.withBatch(10000,"insert into test_domain (id,version) (SELECT nextval('hibernate_sequence'), 0)") { ps ->
//                (1..1000000).each {
//                    ps.addBatch()
//                }
//            }

            //h2
            sql.withBatch('insert into test_domain values (?,0)') { ps ->
                (1..1000000).each {
                    ps.addBatch(it)
                }
            }
            println "Done"
        }




    }
    def destroy = {
    }
}
