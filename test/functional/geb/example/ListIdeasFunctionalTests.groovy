package geb.example

import geb.example.pages.IdeaListPage
import geb.example.remote.IdeaRemoteControl
import org.junit.Test

class ListIdeasFunctionalTests extends geb.junit4.GebReportingTest {
  IdeaRemoteControl ideaRemoteControl = new IdeaRemoteControl()

  @Test
  void shouldListIdeas() {
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
