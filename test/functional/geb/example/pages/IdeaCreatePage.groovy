package geb.example.pages

import org.openqa.selenium.Keys

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
      moveRatingSliderWithMouse(rating)
    }

    createButton.click()

    return browser.page
  }

  void moveRatingSliderWithMouse(Integer rating) {
    // Slider is 400 pixels wide and starts at 1, so each notch above 1 is 100 pixels apart
    Integer numPixels = (rating - 1) * 100

    interact {
      clickAndHold(ratingSliderHandle)
      moveByOffset(numPixels, 0)
      release()
    }
  }

  IdeaShowPage createIdeaUsingKeyboard(String title, String description, Integer rating = null) {
    titleField << title
    descriptionField << description

    if (rating) {
      moveRatingSliderWithKeyboard(rating)
    }

    createButton.click()

    return browser.page
  }

  void moveRatingSliderWithKeyboard(Integer rating) {
    Integer numberOfKeystrokes = rating - 1

    numberOfKeystrokes.times {
      ratingSliderHandle << Keys.ARROW_RIGHT
    }
  }

}
