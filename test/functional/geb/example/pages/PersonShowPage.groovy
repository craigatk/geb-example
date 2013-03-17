package geb.example.pages

class PersonShowPage extends geb.Page {
  static at = { $("div.show-person").displayed }

  static content = {
    firstNameField(wait: true) { $("span#firstName") }
    middleInitialField(wait: true) { $("span#middleInitial") }
    lastNameField(wait: true) { $("span#lastName") }

    streetAddressField(wait: true) { $("span#streetAddress") }
    streetAddress2Field(wait: true) { $("span#streetAddress2") }
    cityField(wait: true) { $("span#city") }
    stateField(wait: true) { $("span#state") }
    zipCodeField(wait: true) { $("span#zipCode") }
  }

  String getFirstName() { firstNameField.text() }

  String getMiddleInitial() { middleInitialField.text() }

  String getLastName() { lastNameField.text() }

  String getStreetAddress() { streetAddressField.text() }

  String getStreetAddress2() { streetAddress2Field.text() }

  String getCity() { cityField.text() }

  String getState() { stateField.text() }

  String getZipCode() { zipCodeField.text() }
}
