package geb.example

class Idea {
  String title
  String description

  static constraints = {
    title(nullable: false, blank: false, maxSize: 80)
    description(nullable: false, blank: false, maxSize: 1000)
  }
}
