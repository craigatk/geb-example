package geb.example.pages

class IdeaCreatePage extends geb.Page {
  static url = "idea/create"
  static at = { $("div#create-idea").displayed }

  static content = {
    titleField { $("input#title") }
    descriptionField { $("textarea#description") }
    ratingSliderHandle { $(".ui-slider-handle") }

    createButton(to: IdeaShowPage) { $("input#create") }
  }

  IdeaShowPage createIdea(String title, String description, Integer rating = null) {
    titleField.value(title)
    descriptionField.value(description)

    if (rating) {
      // Slider is 400 pixels wide and starts at 1, so each notch above 1 is 100 pixels apart
      Integer numPixels = (rating - 1) * 100

      interact {
        clickAndHold(ratingSliderHandle)
        moveByOffset(numPixels, 0)
        release()
      }
    }

    createButton.click()

    return browser.page
  }
}
