package geb.example.pages

class IdeaListPage extends geb.Page {
  static url = "idea/list"
  static at = { $("div#list-idea").displayed }

  static content = {
    ideaListTable { moduleList IdeaListRow, $("table#ideaList tbody tr") }
  }

  String findDescription(String title) {
    IdeaListRow ideaListRow = ideaListTable.find { it.titleCell.text() == title }

    return ideaListRow?.descriptionCell?.text()
  }
}

class IdeaListRow extends geb.Module {
  static content = {
    titleCell { $("td.listTitleTest") }
    descriptionCell { $("td.listDescriptionTest") }
  }
}
