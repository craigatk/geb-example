package geb.example

class Idea implements Serializable {
  private static final long serialVersionUID = 2L

  String title
  String description
  Integer rating

  static constraints = {
    title(nullable: false, blank: false, maxSize: 80)
    description(nullable: false, blank: false, maxSize: 1000)
    rating(nullable: true)
  }
}
