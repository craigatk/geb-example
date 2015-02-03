package geb.example.pages

class PersonShowPage extends geb.Page {
  static at = { $("div#show-person").displayed }

  static content = {
    firstNameField { $("span#firstName") }
    middleInitialField { $("span#middleInitial") }
    lastNameField { $("span#lastName") }

    streetAddressField { $("span#streetAddress") }
    streetAddress2Field { $("span#streetAddress2") }
    cityField { $("span#city") }
    stateField { $("span#state") }
    zipCodeField { $("span#zipCode") }
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
