package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(TrainingAssignmentController)
@Mock(TrainingAssignment)
class TrainingAssignmentControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/trainingAssignment/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.trainingAssignmentInstanceList.size() == 0
        assert model.trainingAssignmentInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.trainingAssignmentInstance != null
    }

    void testSave() {
        controller.save()

        assert model.trainingAssignmentInstance != null
        assert view == '/trainingAssignment/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/trainingAssignment/show/1'
        assert controller.flash.message != null
        assert TrainingAssignment.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/trainingAssignment/list'

        populateValidParams(params)
        def trainingAssignment = new TrainingAssignment(params)

        assert trainingAssignment.save() != null

        params.id = trainingAssignment.id

        def model = controller.show()

        assert model.trainingAssignmentInstance == trainingAssignment
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/trainingAssignment/list'

        populateValidParams(params)
        def trainingAssignment = new TrainingAssignment(params)

        assert trainingAssignment.save() != null

        params.id = trainingAssignment.id

        def model = controller.edit()

        assert model.trainingAssignmentInstance == trainingAssignment
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/trainingAssignment/list'

        response.reset()

        populateValidParams(params)
        def trainingAssignment = new TrainingAssignment(params)

        assert trainingAssignment.save() != null

        // test invalid parameters in update
        params.id = trainingAssignment.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/trainingAssignment/edit"
        assert model.trainingAssignmentInstance != null

        trainingAssignment.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/trainingAssignment/show/$trainingAssignment.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        trainingAssignment.clearErrors()

        populateValidParams(params)
        params.id = trainingAssignment.id
        params.version = -1
        controller.update()

        assert view == "/trainingAssignment/edit"
        assert model.trainingAssignmentInstance != null
        assert model.trainingAssignmentInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/trainingAssignment/list'

        response.reset()

        populateValidParams(params)
        def trainingAssignment = new TrainingAssignment(params)

        assert trainingAssignment.save() != null
        assert TrainingAssignment.count() == 1

        params.id = trainingAssignment.id

        controller.delete()

        assert TrainingAssignment.count() == 0
        assert TrainingAssignment.get(trainingAssignment.id) == null
        assert response.redirectedUrl == '/trainingAssignment/list'
    }
}
