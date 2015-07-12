package geb.example
import geb.example.pages.IdeaCreatePage
import geb.example.pages.IdeaShowPage
import geb.example.remote.IdeaRemoteControl
import geb.spock.GebReportingSpec

class CreateIdeaWithRatingFunctionalSpec extends GebReportingSpec {
    def "should create new idea with rating"() {
        given: "the idea creation page"
        IdeaRemoteControl ideaRemoteControl = new IdeaRemoteControl()

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
