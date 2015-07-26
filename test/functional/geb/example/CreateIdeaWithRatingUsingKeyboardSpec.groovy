package geb.example

import geb.example.pages.IdeaCreatePage
import geb.example.pages.IdeaShowPage
import geb.example.remote.IdeaRemoteControl
import geb.spock.GebReportingSpec
import spock.lang.Unroll

class CreateIdeaWithRatingUsingKeyboardSpec extends GebReportingSpec {
    @Unroll
    def "should create new idea with rating #rating"() {
        given: "the idea creation page"
        IdeaRemoteControl ideaRemoteControl = new IdeaRemoteControl()

        IdeaCreatePage ideaCreatePage = to(IdeaCreatePage)

        when: "the user creates a new idea with a rating"
        IdeaShowPage ideaShowPage = ideaCreatePage.createIdeaUsingKeyboard(ideaTitle, ideaDescription, rating)

        then: "should show the new idea"
        assert ideaShowPage.titleText == ideaTitle
        assert ideaShowPage.descriptionText == ideaDescription

        and: "should create the new idea in the database"
        Idea newIdea = ideaRemoteControl.findByTitle(ideaTitle)

        assert newIdea?.description == ideaDescription
        assert newIdea?.rating == rating

        where:
        rating | ideaTitle     | ideaDescription
        2      | "First Idea"  | "I've had better ideas"
        3      | "Second Idea" | "Not the worst idea"
        4      | "Third Idea"  | "This idea might actually work"
        5      | "Fourth Idea" | "This idea will change the world"
    }
}
