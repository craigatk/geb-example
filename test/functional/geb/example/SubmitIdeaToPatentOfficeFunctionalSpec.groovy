package geb.example
import geb.example.pages.IdeaCreatePage
import geb.example.pages.IdeaShowPage
import geb.example.remote.IdeaRemoteControl
import geb.spock.GebReportingSpec

class SubmitIdeaToPatentOfficeFunctionalSpec extends GebReportingSpec {
    def 'should submit idea to patent office'() {
        given:
        IdeaRemoteControl ideaRemoteControl = new IdeaRemoteControl()
        IdeaCreatePage ideaCreatePage = to(IdeaCreatePage)

        when:
        String ideaTitle = "Patentable Idea"
        String ideaDescription = "This idea is going to change the world"

        IdeaShowPage ideaShowPage = ideaCreatePage.createIdea(ideaTitle, ideaDescription)

        ideaShowPage = ideaShowPage.submitIdeaToPatentOffice()

        then:
        Idea newIdea = ideaRemoteControl.findByTitle(ideaTitle)
        List<Idea> ideasSubmittedToPatentOffice = ideaRemoteControl
                .findIdeasSubmittedToPatentOffice()
        assert ideasSubmittedToPatentOffice*.id.contains(newIdea.id)
    }
}
