package geb.example



import org.junit.*
import grails.test.mixin.*

@TestFor(IdeaController)
@Mock(Idea)
class IdeaControllerTests {

  def populateValidParams(params) {
    assert params != null
    // TODO: Populate valid properties like...
    //params["name"] = 'someValidName'
  }

  void testIndex() {
    controller.index()
    assert "/idea/list" == response.redirectedUrl
  }

  void testList() {

    def model = controller.list()

    assert model.ideaInstanceList.size() == 0
    assert model.ideaInstanceTotal == 0
  }

  void testCreate() {
    def model = controller.create()

    assert model.ideaInstance != null
  }

  void testSave() {
    controller.save()

    assert model.ideaInstance != null
    assert view == '/idea/create'

    response.reset()

    populateValidParams(params)
    controller.save()

    assert response.redirectedUrl == '/idea/show/1'
    assert controller.flash.message != null
    assert Idea.count() == 1
  }

  void testShow() {
    controller.show()

    assert flash.message != null
    assert response.redirectedUrl == '/idea/list'

    populateValidParams(params)
    def idea = new Idea(params)

    assert idea.save() != null

    params.id = idea.id

    def model = controller.show()

    assert model.ideaInstance == idea
  }

  void testEdit() {
    controller.edit()

    assert flash.message != null
    assert response.redirectedUrl == '/idea/list'

    populateValidParams(params)
    def idea = new Idea(params)

    assert idea.save() != null

    params.id = idea.id

    def model = controller.edit()

    assert model.ideaInstance == idea
  }

  void testUpdate() {
    controller.update()

    assert flash.message != null
    assert response.redirectedUrl == '/idea/list'

    response.reset()

    populateValidParams(params)
    def idea = new Idea(params)

    assert idea.save() != null

    // test invalid parameters in update
    params.id = idea.id
    //TODO: add invalid values to params object

    controller.update()

    assert view == "/idea/edit"
    assert model.ideaInstance != null

    idea.clearErrors()

    populateValidParams(params)
    controller.update()

    assert response.redirectedUrl == "/idea/show/$idea.id"
    assert flash.message != null

    //test outdated version number
    response.reset()
    idea.clearErrors()

    populateValidParams(params)
    params.id = idea.id
    params.version = -1
    controller.update()

    assert view == "/idea/edit"
    assert model.ideaInstance != null
    assert model.ideaInstance.errors.getFieldError('version')
    assert flash.message != null
  }

  void testDelete() {
    controller.delete()
    assert flash.message != null
    assert response.redirectedUrl == '/idea/list'

    response.reset()

    populateValidParams(params)
    def idea = new Idea(params)

    assert idea.save() != null
    assert Idea.count() == 1

    params.id = idea.id

    controller.delete()

    assert Idea.count() == 0
    assert Idea.get(idea.id) == null
    assert response.redirectedUrl == '/idea/list'
  }
}
