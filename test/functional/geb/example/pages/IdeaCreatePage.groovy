package geb.example.pages

class IdeaCreatePage extends geb.Page {
  static url = "idea/create"
  static at = { $("div#create-idea").displayed }

  static content = {
    titleField { $("input#title") }
    descriptionField { $("textarea#description") }

    createButton(to: IdeaShowPage) { $("input#create") }
  }

  IdeaShowPage createIdea(String title, String description) {
    titleField.value(title)
    descriptionField.value(description)

    createButton.click()

    return browser.page
  }
}
