package geb.example.pages

class IdeaListPage extends geb.Page {
  static url = "idea/list"
  static at = { $("div#list-idea").displayed }

  static content = {
    ideaListTable(wait: true) { moduleList IdeaListRow, $("table#ideaList tbody tr") }
  }

  String findDescription(String title) {
    IdeaListRow ideaListRow = ideaListTable.find { it.titleCell.text() == title }

    return ideaListRow?.descriptionCell?.text()
  }
}

class IdeaListRow extends geb.Module {
  static content = {
    titleCell(wait: true) { $("td.listTitleTest") }
    descriptionCell(wait: true) { $("td.listDescriptionTest") }
  }
}
