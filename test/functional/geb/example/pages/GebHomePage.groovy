package geb.example.pages

class GebHomePage extends geb.Page {
    static at = { title == "Geb - Very Groovy Browser Automation" }

    static content = {
        mainDiv(wait: true) { $("#main") }
        manualLinkInMainDiv(to: GebManualPage) {  mainDiv.find("a", text: 'Book of Geb').first() }
    }

    GebManualPage clickManualLink() {
        manualLinkInMainDiv.click()

        return browser.page
    }
}
