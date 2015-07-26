package geb.example.pages

class GoogleHomePage extends geb.Page {
    static url = "http://www.google.com"

    static content = {
        searchBox { $("input", name: "q") }
        searchButton { $("button", name: "btnG") }
        searchResultsText(wait: true) { $("#search").text() }
        searchResultsLinks(wait: true) { $("h3.r") }
    }
}
