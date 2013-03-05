package geb.example

import geb.example.pages.CreateIdeaPage
import geb.example.pages.ShowIdeaPage
import org.junit.Test

class CreateIdeaFunctionalTests extends geb.junit4.GebReportingTest {
  @Test
  void shouldCreateNewIdea() {
    String ideaTitle = "My new idea"
    String ideaDescription = "It's going to be a good idea."

    to CreateIdeaPage

    CreateIdeaPage createIdeaPage = browser.page

    ShowIdeaPage showIdeaPage = createIdeaPage.createIdea(ideaTitle, ideaDescription)

    assert showIdeaPage.titleText == ideaTitle
    assert showIdeaPage.descriptionText == ideaDescription
  }
}
