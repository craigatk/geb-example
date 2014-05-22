package geb.example

import geb.example.pages.IdeaListPage
import geb.example.remote.IdeaRemoteControl

// JUnit3-style test
class ListIdeasFunctionalTests extends geb.junit3.GebReportingTest {
  IdeaRemoteControl ideaRemoteControl = new IdeaRemoteControl()

  void testShouldListIdeas() {
    ideaRemoteControl.deleteAllIdeas()

    List<Idea> ideas = (1..5).collect { i ->
      ideaRemoteControl.createIdea("Title ${i}", "Description ${i}")
    }

    IdeaListPage ideaListPage = to(IdeaListPage)

    ideas.each { idea ->
      assert ideaListPage.findDescription(idea.title) == idea.description
    }
  }
}
