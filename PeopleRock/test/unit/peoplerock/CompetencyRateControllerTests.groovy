package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(CompetencyRateController)
@Mock(CompetencyRate)
class CompetencyRateControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/competencyRate/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.competencyRateInstanceList.size() == 0
        assert model.competencyRateInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.competencyRateInstance != null
    }

    void testSave() {
        controller.save()

        assert model.competencyRateInstance != null
        assert view == '/competencyRate/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/competencyRate/show/1'
        assert controller.flash.message != null
        assert CompetencyRate.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/competencyRate/list'

        populateValidParams(params)
        def competencyRate = new CompetencyRate(params)

        assert competencyRate.save() != null

        params.id = competencyRate.id

        def model = controller.show()

        assert model.competencyRateInstance == competencyRate
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/competencyRate/list'

        populateValidParams(params)
        def competencyRate = new CompetencyRate(params)

        assert competencyRate.save() != null

        params.id = competencyRate.id

        def model = controller.edit()

        assert model.competencyRateInstance == competencyRate
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/competencyRate/list'

        response.reset()

        populateValidParams(params)
        def competencyRate = new CompetencyRate(params)

        assert competencyRate.save() != null

        // test invalid parameters in update
        params.id = competencyRate.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/competencyRate/edit"
        assert model.competencyRateInstance != null

        competencyRate.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/competencyRate/show/$competencyRate.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        competencyRate.clearErrors()

        populateValidParams(params)
        params.id = competencyRate.id
        params.version = -1
        controller.update()

        assert view == "/competencyRate/edit"
        assert model.competencyRateInstance != null
        assert model.competencyRateInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/competencyRate/list'

        response.reset()

        populateValidParams(params)
        def competencyRate = new CompetencyRate(params)

        assert competencyRate.save() != null
        assert CompetencyRate.count() == 1

        params.id = competencyRate.id

        controller.delete()

        assert CompetencyRate.count() == 0
        assert CompetencyRate.get(competencyRate.id) == null
        assert response.redirectedUrl == '/competencyRate/list'
    }
}
