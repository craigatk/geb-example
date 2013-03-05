package geb.example.pages

class ShowIdeaPage extends geb.Page {
  static at = { $("div#show-idea").displayed }

  static content = {
    titleValueElement(wait: true) { $("span#titleValue") }
    descriptionValueElement(wait: true) { $("span#descriptionValue") }
  }

  String getTitleText() {
    titleValueElement.text()
  }

  String getDescriptionText() {
    descriptionValueElement.text()
  }
}
