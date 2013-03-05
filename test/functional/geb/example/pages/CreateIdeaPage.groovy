package geb.example.pages

class CreateIdeaPage extends geb.Page {
  static url = "idea/create"
  static at = { $("div#create-idea").displayed }

  static content = {
    titleField(wait: true) { $("input#title") }
    descriptionField(wait: true) { $("textarea#description") }

    createButton(wait: true, to: ShowIdeaPage) { $("input#create") }
  }

  ShowIdeaPage createIdea(String title, String description) {
    titleField.value(title)
    descriptionField.value(description)

    createButton.click()

    return browser.page
  }
}
