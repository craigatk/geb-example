package geb.example

import geb.example.pages.IdeaCreatePage
import geb.example.pages.IdeaShowPage
import geb.example.remote.IdeaRemoteControl

class CreateIdeaFunctionalSpec extends geb.spock.GebReportingSpec {
  IdeaRemoteControl ideaRemoteControl = new IdeaRemoteControl()

  def "should create a new idea"() {
    given: "the idea creation page"
    IdeaCreatePage ideaCreatePage = to(IdeaCreatePage)

    when: "the user creates a new idea"
    String ideaTitle = "My new idea"
    String ideaDescription = "It's going to be a good idea."

    IdeaShowPage ideaShowPage = ideaCreatePage.createIdea(ideaTitle, ideaDescription)

    then: "should show the new idea"
    assert ideaShowPage.titleText == ideaTitle
    assert ideaShowPage.descriptionText == ideaDescription

    and: "should create the new idea in the database"
    assert ideaRemoteControl.findByTitle(ideaTitle)?.description == ideaDescription
  }

  def "should create new idea with rating"() {
    given: "the idea creation page"
    IdeaCreatePage ideaCreatePage = to(IdeaCreatePage)

    when: "the user creates a new idea with a rating"
    String ideaTitle = "My new great idea"
    String ideaDescription = "It's going to be the best idea."
    Integer rating = 5

    IdeaShowPage ideaShowPage = ideaCreatePage.createIdea(ideaTitle, ideaDescription, rating)

    then: "should show the new idea"
    assert ideaShowPage.titleText == ideaTitle
    assert ideaShowPage.descriptionText == ideaDescription

    and: "should create the new idea in the database"
    Idea newIdea = ideaRemoteControl.findByTitle(ideaTitle)

    assert newIdea?.description == ideaDescription
    assert newIdea?.rating == rating
  }
}
