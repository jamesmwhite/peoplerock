package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(PersonCompetencyController)
@Mock(PersonCompetency)
class PersonCompetencyControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/personCompetency/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.personCompetencyInstanceList.size() == 0
        assert model.personCompetencyInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.personCompetencyInstance != null
    }

    void testSave() {
        controller.save()

        assert model.personCompetencyInstance != null
        assert view == '/personCompetency/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/personCompetency/show/1'
        assert controller.flash.message != null
        assert PersonCompetency.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/personCompetency/list'

        populateValidParams(params)
        def personCompetency = new PersonCompetency(params)

        assert personCompetency.save() != null

        params.id = personCompetency.id

        def model = controller.show()

        assert model.personCompetencyInstance == personCompetency
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/personCompetency/list'

        populateValidParams(params)
        def personCompetency = new PersonCompetency(params)

        assert personCompetency.save() != null

        params.id = personCompetency.id

        def model = controller.edit()

        assert model.personCompetencyInstance == personCompetency
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/personCompetency/list'

        response.reset()

        populateValidParams(params)
        def personCompetency = new PersonCompetency(params)

        assert personCompetency.save() != null

        // test invalid parameters in update
        params.id = personCompetency.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/personCompetency/edit"
        assert model.personCompetencyInstance != null

        personCompetency.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/personCompetency/show/$personCompetency.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        personCompetency.clearErrors()

        populateValidParams(params)
        params.id = personCompetency.id
        params.version = -1
        controller.update()

        assert view == "/personCompetency/edit"
        assert model.personCompetencyInstance != null
        assert model.personCompetencyInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/personCompetency/list'

        response.reset()

        populateValidParams(params)
        def personCompetency = new PersonCompetency(params)

        assert personCompetency.save() != null
        assert PersonCompetency.count() == 1

        params.id = personCompetency.id

        controller.delete()

        assert PersonCompetency.count() == 0
        assert PersonCompetency.get(personCompetency.id) == null
        assert response.redirectedUrl == '/personCompetency/list'
    }
}
