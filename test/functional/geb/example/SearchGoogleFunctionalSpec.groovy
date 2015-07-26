package geb.example

import geb.example.pages.GebHomePage
import geb.example.pages.GoogleHomePage
import geb.spock.GebReportingSpec
import spock.lang.Ignore

class SearchGoogleFunctionalSpec extends GebReportingSpec {

    // Comment out the @Ignore line below if you want to run this test
    @Ignore
    def 'should use Google to find the Geb home page'() {
        given:
        go "http://www.google.com"

        when:
        $("input", name: "q").value("geb")
        $("button", name: "btnG").click()

        waitFor { $("#search").displayed }

        $("h3.r").first().click()

        then:
        waitFor { title == "Geb - Very Groovy Browser Automation" }
    }

    // Comment out the @Ignore line below if you want to run this test
    @Ignore
    def 'should use Google to find Geb home page with Page Objects'() {
        given:
        to GoogleHomePage

        when:
        searchBox = "Geb"

        searchButton.click()

        searchResultsLinks.first().click()

        then:
        assert at(GebHomePage)
    }
}
