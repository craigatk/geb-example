package geb.example
import geb.example.pages.CreateIdeaPage
import geb.example.pages.ShowIdeaPage

class CreateIdeaFunctionalSpec extends geb.spock.GebReportingSpec {
  def "should create a new idea"() {
    given: "the idea creation page"
    CreateIdeaPage createIdeaPage = to(CreateIdeaPage)

    when: "the user creates a new idea"
    String ideaTitle = "My new idea"
    String ideaDescription = "It's going to be a good idea."

    ShowIdeaPage showIdeaPage = createIdeaPage.createIdea(ideaTitle, ideaDescription)

    then: "should show the new idea"
    assert showIdeaPage.titleText == ideaTitle
    assert showIdeaPage.descriptionText == ideaDescription
  }
}
