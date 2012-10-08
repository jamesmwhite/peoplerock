package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(CompetenciesController)
@Mock(Competencies)
class CompetenciesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/competencies/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.competenciesInstanceList.size() == 0
        assert model.competenciesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.competenciesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.competenciesInstance != null
        assert view == '/competencies/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/competencies/show/1'
        assert controller.flash.message != null
        assert Competencies.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/competencies/list'

        populateValidParams(params)
        def competencies = new Competencies(params)

        assert competencies.save() != null

        params.id = competencies.id

        def model = controller.show()

        assert model.competenciesInstance == competencies
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/competencies/list'

        populateValidParams(params)
        def competencies = new Competencies(params)

        assert competencies.save() != null

        params.id = competencies.id

        def model = controller.edit()

        assert model.competenciesInstance == competencies
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/competencies/list'

        response.reset()

        populateValidParams(params)
        def competencies = new Competencies(params)

        assert competencies.save() != null

        // test invalid parameters in update
        params.id = competencies.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/competencies/edit"
        assert model.competenciesInstance != null

        competencies.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/competencies/show/$competencies.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        competencies.clearErrors()

        populateValidParams(params)
        params.id = competencies.id
        params.version = -1
        controller.update()

        assert view == "/competencies/edit"
        assert model.competenciesInstance != null
        assert model.competenciesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/competencies/list'

        response.reset()

        populateValidParams(params)
        def competencies = new Competencies(params)

        assert competencies.save() != null
        assert Competencies.count() == 1

        params.id = competencies.id

        controller.delete()

        assert Competencies.count() == 0
        assert Competencies.get(competencies.id) == null
        assert response.redirectedUrl == '/competencies/list'
    }
}
