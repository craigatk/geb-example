package geb.example
import geb.example.pages.IdeaCreatePage
import geb.example.pages.IdeaShowPage
import geb.example.remote.IdeaRemoteControl
import geb.spock.GebReportingSpec

class SubmitIdeaToPatentOfficeFunctionalSpec extends GebReportingSpec {
    IdeaRemoteControl ideaRemoteControl

    def setup() {
        ideaRemoteControl = new IdeaRemoteControl()

        ideaRemoteControl.resetMockPatentService()
    }

    def cleanup() {
        ideaRemoteControl.resetMockPatentService()
    }

    def 'should submit idea to patent office'() {
        given:
        IdeaCreatePage ideaCreatePage = to(IdeaCreatePage)

        when:
        String ideaTitle = "Patentable Idea"
        String ideaDescription = "This idea is going to change the world"

        IdeaShowPage ideaShowPage = ideaCreatePage.createIdea(ideaTitle, ideaDescription)

        ideaShowPage = ideaShowPage.submitIdeaToPatentOffice()

        then:
        Idea newIdea = ideaRemoteControl.findByTitle(ideaTitle)

        assert ideaRemoteControl.findIdeasSubmittedToPatentOffice()*.id.contains(newIdea.id)
    }
}
