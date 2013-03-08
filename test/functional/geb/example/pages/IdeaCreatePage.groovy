package geb.example.pages

class IdeaCreatePage extends geb.Page {
  static url = "idea/create"
  static at = { $("div#create-idea").displayed }

  static content = {
    titleField(wait: true) { $("input#title") }
    descriptionField(wait: true) { $("textarea#description") }

    createButton(wait: true, to: IdeaShowPage) { $("input#create") }
  }

  IdeaShowPage createIdea(String title, String description) {
    titleField.value(title)
    descriptionField.value(description)

    createButton.click()

    return browser.page
  }
}
