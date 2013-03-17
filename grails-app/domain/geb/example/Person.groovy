package geb.example

class Person {
  String firstName
  String middleInitial
  String lastName

  String streetAddress
  String streetAddress2
  String city
  String state
  String zipCode

  static constraints = {
    firstName(nullable: false, blank: false)
    middleInitial(nullable: true)
    lastName(nullable: false, blank: false)

    streetAddress(nullable: false, blank: false)
    streetAddress2(nullable: true)
    city(nullable: false, blank: false)
    state(nullable: false, blank: false)
    zipCode(nullable: false, blank: false)
  }
}
