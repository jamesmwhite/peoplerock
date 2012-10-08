package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(ProjectAssignmentController)
@Mock(ProjectAssignment)
class ProjectAssignmentControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/projectAssignment/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.projectAssignmentInstanceList.size() == 0
        assert model.projectAssignmentInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.projectAssignmentInstance != null
    }

    void testSave() {
        controller.save()

        assert model.projectAssignmentInstance != null
        assert view == '/projectAssignment/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/projectAssignment/show/1'
        assert controller.flash.message != null
        assert ProjectAssignment.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/projectAssignment/list'

        populateValidParams(params)
        def projectAssignment = new ProjectAssignment(params)

        assert projectAssignment.save() != null

        params.id = projectAssignment.id

        def model = controller.show()

        assert model.projectAssignmentInstance == projectAssignment
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/projectAssignment/list'

        populateValidParams(params)
        def projectAssignment = new ProjectAssignment(params)

        assert projectAssignment.save() != null

        params.id = projectAssignment.id

        def model = controller.edit()

        assert model.projectAssignmentInstance == projectAssignment
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/projectAssignment/list'

        response.reset()

        populateValidParams(params)
        def projectAssignment = new ProjectAssignment(params)

        assert projectAssignment.save() != null

        // test invalid parameters in update
        params.id = projectAssignment.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/projectAssignment/edit"
        assert model.projectAssignmentInstance != null

        projectAssignment.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/projectAssignment/show/$projectAssignment.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        projectAssignment.clearErrors()

        populateValidParams(params)
        params.id = projectAssignment.id
        params.version = -1
        controller.update()

        assert view == "/projectAssignment/edit"
        assert model.projectAssignmentInstance != null
        assert model.projectAssignmentInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/projectAssignment/list'

        response.reset()

        populateValidParams(params)
        def projectAssignment = new ProjectAssignment(params)

        assert projectAssignment.save() != null
        assert ProjectAssignment.count() == 1

        params.id = projectAssignment.id

        controller.delete()

        assert ProjectAssignment.count() == 0
        assert ProjectAssignment.get(projectAssignment.id) == null
        assert response.redirectedUrl == '/projectAssignment/list'
    }
}
