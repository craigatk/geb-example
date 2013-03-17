package geb.example
import geb.example.pages.PersonCreatePage
import geb.example.pages.PersonShowPage
import geb.junit4.GebReportingTest
import org.junit.Test

class CreatePersonFunctionalTests extends GebReportingTest {
  String newFirstName = "John"
  String newMiddleInitial = "A"
  String newLastName = "Smith"

  String newStreetAddress = "100 Main Street"
  String newStreetAddress2 = "Suite 100"
  String newCity = "Minneapolis"
  String newState = "MN"
  String newZipCode = "55408"

  @Test
  void shouldCreateNewPersonUsingDirectContentAccess() {
    to(PersonCreatePage)

    firstNameField = newFirstName
    middleInitialField = newMiddleInitial
    lastNameField = newLastName

    streetAddressField = newStreetAddress
    streetAddress2Field = newStreetAddress2
    cityField = newCity
    stateField = newState
    zipCodeField = newZipCode

    createButton.click()

    assert firstNameField.text() == newFirstName
    assert middleInitialField.text() == newMiddleInitial
    assert lastNameField.text() == newLastName

    assert streetAddressField.text() == newStreetAddress
    assert streetAddress2Field.text() == newStreetAddress2
    assert cityField.text() == newCity
    assert stateField.text() == newState
    assert zipCodeField.text() == newZipCode
  }

  @Test
  void shouldCreateNewPersonUsingPageObjectMethods() {
    PersonCreatePage personCreatePage = to(PersonCreatePage)

    personCreatePage.setNameFields(newFirstName, newMiddleInitial, newLastName)

    personCreatePage.setAddressFields(newStreetAddress, newStreetAddress2, newCity, newState, newZipCode)

    PersonShowPage personShowPage = personCreatePage.clickCreateButton()

    assert personShowPage.firstName == newFirstName
    assert personShowPage.middleInitial == newMiddleInitial
    assert personShowPage.lastName == newLastName

    assert personShowPage.streetAddress == newStreetAddress
    assert personShowPage.streetAddress2 == newStreetAddress2
    assert personShowPage.city == newCity
    assert personShowPage.state == newState
    assert personShowPage.zipCode == newZipCode
  }
}
