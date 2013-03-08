package geb.example

import geb.example.pages.IdeaListPage
import geb.example.remote.IdeaRemoteControl

class ListIdeasFunctionalSpec extends geb.spock.GebReportingSpec {
  IdeaRemoteControl ideaRemoteControl = new IdeaRemoteControl()

  def "should list ideas"() {
    given: "five existing ideas"
    List<Idea> ideas = (1..5).collect { i ->
      ideaRemoteControl.createIdea("Title ${i}", "Description ${i}")
    }

    when: "on the idea list page"
    IdeaListPage ideaListPage = to(IdeaListPage)

    then: "should list each idea's title and description"
    ideas.each { idea ->
      assert ideaListPage.findDescription(idea.title) == idea.description
    }
  }
}
