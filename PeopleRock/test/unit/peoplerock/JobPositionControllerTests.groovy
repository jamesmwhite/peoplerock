package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(JobPositionController)
@Mock(JobPosition)
class JobPositionControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/jobPosition/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.jobPositionInstanceList.size() == 0
        assert model.jobPositionInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.jobPositionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.jobPositionInstance != null
        assert view == '/jobPosition/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/jobPosition/show/1'
        assert controller.flash.message != null
        assert JobPosition.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/jobPosition/list'

        populateValidParams(params)
        def jobPosition = new JobPosition(params)

        assert jobPosition.save() != null

        params.id = jobPosition.id

        def model = controller.show()

        assert model.jobPositionInstance == jobPosition
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/jobPosition/list'

        populateValidParams(params)
        def jobPosition = new JobPosition(params)

        assert jobPosition.save() != null

        params.id = jobPosition.id

        def model = controller.edit()

        assert model.jobPositionInstance == jobPosition
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/jobPosition/list'

        response.reset()

        populateValidParams(params)
        def jobPosition = new JobPosition(params)

        assert jobPosition.save() != null

        // test invalid parameters in update
        params.id = jobPosition.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/jobPosition/edit"
        assert model.jobPositionInstance != null

        jobPosition.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/jobPosition/show/$jobPosition.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        jobPosition.clearErrors()

        populateValidParams(params)
        params.id = jobPosition.id
        params.version = -1
        controller.update()

        assert view == "/jobPosition/edit"
        assert model.jobPositionInstance != null
        assert model.jobPositionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/jobPosition/list'

        response.reset()

        populateValidParams(params)
        def jobPosition = new JobPosition(params)

        assert jobPosition.save() != null
        assert JobPosition.count() == 1

        params.id = jobPosition.id

        controller.delete()

        assert JobPosition.count() == 0
        assert JobPosition.get(jobPosition.id) == null
        assert response.redirectedUrl == '/jobPosition/list'
    }
}
