package geb.example
import geb.spock.GebReportingSpec
import spock.lang.Ignore

class SearchGoogleFunctionalSpec extends GebReportingSpec {
    // Comment out the @Ignore line below if you want to run this test
    @Ignore
    def 'should search Google for Geb'() {
        given:
        go "http://www.google.com"

        when:
        $("input", name: "q").value("geb")
        $("button", name: "btnG").click()

        then:
        waitFor { $("#search").displayed }

        assert $("#search").text().contains("gebish.org")
    }
}
