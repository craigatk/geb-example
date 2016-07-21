package geb.example.pages

import geb.Page

class GoogleHomePage extends geb.Page {
    static url = "http://www.google.com"

    static content = {
        searchBox { $("input", name: "q") }
        searchButton { $("button", name: "btnG") }
        searchResultsText(wait: true) { $("#search").text() }
        searchResultsLinks(wait: true) { $("h3.r") }
    }

    void searchFor(String query) {
        searchBox.value(query)

        searchButton.click()
    }

    Page clickFirstResult(Class destinationPageClass) {
        searchResultsLinks.first().click(destinationPageClass)

        return browser.page
    }
}
