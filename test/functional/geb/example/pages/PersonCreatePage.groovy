package geb.example.pages

class PersonCreatePage extends geb.Page {
  static at = { $("div#create-person").displayed }

  static url = "person/create"

  static content = {
    firstNameField(wait: true) { $("input#firstName") }
    middleInitialField(wait: true) { $("input#middleInitial") }
    lastNameField(wait: true) { $("input#lastName") }

    streetAddressField(wait: true) { $("input#streetAddress") }
    streetAddress2Field(wait: true) { $("input#streetAddress2") }
    cityField(wait: true) { $("input#city") }
    stateField(wait: true) { $("input#state") }
    zipCodeField(wait: true) { $("input#zipCode") }

    createButton(wait: true, to: PersonShowPage) { $("input#create") }
  }

  void setNameFields(String firstName, String middleInitial, String lastName) {
    firstNameField.value(firstName)
    middleInitialField.value(middleInitial)
    lastNameField.value(lastName)
  }

  void setAddressFields(String streetAddress, String streetAddress2, String city, String state, String zipCode) {
    streetAddressField.value(streetAddress)
    streetAddress2Field.value(streetAddress2)
    cityField.value(city)
    stateField.value(state)
    zipCodeField.value(zipCode)
  }

  PersonShowPage clickCreateButton() {
    createButton.click()

    return browser.page
  }
}
