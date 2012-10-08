package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(CompetencyController)
@Mock(Competency)
class CompetencyControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/competency/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.competencyInstanceList.size() == 0
        assert model.competencyInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.competencyInstance != null
    }

    void testSave() {
        controller.save()

        assert model.competencyInstance != null
        assert view == '/competency/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/competency/show/1'
        assert controller.flash.message != null
        assert Competency.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/competency/list'

        populateValidParams(params)
        def competency = new Competency(params)

        assert competency.save() != null

        params.id = competency.id

        def model = controller.show()

        assert model.competencyInstance == competency
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/competency/list'

        populateValidParams(params)
        def competency = new Competency(params)

        assert competency.save() != null

        params.id = competency.id

        def model = controller.edit()

        assert model.competencyInstance == competency
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/competency/list'

        response.reset()

        populateValidParams(params)
        def competency = new Competency(params)

        assert competency.save() != null

        // test invalid parameters in update
        params.id = competency.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/competency/edit"
        assert model.competencyInstance != null

        competency.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/competency/show/$competency.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        competency.clearErrors()

        populateValidParams(params)
        params.id = competency.id
        params.version = -1
        controller.update()

        assert view == "/competency/edit"
        assert model.competencyInstance != null
        assert model.competencyInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/competency/list'

        response.reset()

        populateValidParams(params)
        def competency = new Competency(params)

        assert competency.save() != null
        assert Competency.count() == 1

        params.id = competency.id

        controller.delete()

        assert Competency.count() == 0
        assert Competency.get(competency.id) == null
        assert response.redirectedUrl == '/competency/list'
    }
}
