package geb.example

import geb.example.pages.IdeaCreatePage
import geb.example.pages.IdeaShowPage
import geb.example.remote.IdeaRemoteControl
import org.junit.Test

class CreateIdeaFunctionalTests extends geb.junit4.GebReportingTest {
  IdeaRemoteControl ideaRemoteControl = new IdeaRemoteControl()

  @Test
  void shouldCreateNewIdea() {
    String ideaTitle = "My new idea"
    String ideaDescription = "It's going to be a good idea."

    IdeaCreatePage ideaCreatePage = to(IdeaCreatePage)

    IdeaShowPage ideaShowPage = ideaCreatePage.createIdea(ideaTitle, ideaDescription)

    assert ideaShowPage.titleText == ideaTitle
    assert ideaShowPage.descriptionText == ideaDescription

    assert ideaRemoteControl.findByTitle(ideaTitle)?.description == ideaDescription
  }
}
