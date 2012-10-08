package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(EmployeeProfileController)
@Mock(EmployeeProfile)
class EmployeeProfileControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/employeeProfile/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.employeeProfileInstanceList.size() == 0
        assert model.employeeProfileInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.employeeProfileInstance != null
    }

    void testSave() {
        controller.save()

        assert model.employeeProfileInstance != null
        assert view == '/employeeProfile/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/employeeProfile/show/1'
        assert controller.flash.message != null
        assert EmployeeProfile.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/employeeProfile/list'

        populateValidParams(params)
        def employeeProfile = new EmployeeProfile(params)

        assert employeeProfile.save() != null

        params.id = employeeProfile.id

        def model = controller.show()

        assert model.employeeProfileInstance == employeeProfile
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/employeeProfile/list'

        populateValidParams(params)
        def employeeProfile = new EmployeeProfile(params)

        assert employeeProfile.save() != null

        params.id = employeeProfile.id

        def model = controller.edit()

        assert model.employeeProfileInstance == employeeProfile
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/employeeProfile/list'

        response.reset()

        populateValidParams(params)
        def employeeProfile = new EmployeeProfile(params)

        assert employeeProfile.save() != null

        // test invalid parameters in update
        params.id = employeeProfile.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/employeeProfile/edit"
        assert model.employeeProfileInstance != null

        employeeProfile.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/employeeProfile/show/$employeeProfile.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        employeeProfile.clearErrors()

        populateValidParams(params)
        params.id = employeeProfile.id
        params.version = -1
        controller.update()

        assert view == "/employeeProfile/edit"
        assert model.employeeProfileInstance != null
        assert model.employeeProfileInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/employeeProfile/list'

        response.reset()

        populateValidParams(params)
        def employeeProfile = new EmployeeProfile(params)

        assert employeeProfile.save() != null
        assert EmployeeProfile.count() == 1

        params.id = employeeProfile.id

        controller.delete()

        assert EmployeeProfile.count() == 0
        assert EmployeeProfile.get(employeeProfile.id) == null
        assert response.redirectedUrl == '/employeeProfile/list'
    }
}
