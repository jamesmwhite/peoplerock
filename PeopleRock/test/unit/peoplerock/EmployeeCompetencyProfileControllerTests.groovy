package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(EmployeeCompetencyProfileController)
@Mock(EmployeeCompetencyProfile)
class EmployeeCompetencyProfileControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/employeeCompetencyProfile/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.employeeCompetencyProfileInstanceList.size() == 0
        assert model.employeeCompetencyProfileInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.employeeCompetencyProfileInstance != null
    }

    void testSave() {
        controller.save()

        assert model.employeeCompetencyProfileInstance != null
        assert view == '/employeeCompetencyProfile/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/employeeCompetencyProfile/show/1'
        assert controller.flash.message != null
        assert EmployeeCompetencyProfile.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/employeeCompetencyProfile/list'

        populateValidParams(params)
        def employeeCompetencyProfile = new EmployeeCompetencyProfile(params)

        assert employeeCompetencyProfile.save() != null

        params.id = employeeCompetencyProfile.id

        def model = controller.show()

        assert model.employeeCompetencyProfileInstance == employeeCompetencyProfile
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/employeeCompetencyProfile/list'

        populateValidParams(params)
        def employeeCompetencyProfile = new EmployeeCompetencyProfile(params)

        assert employeeCompetencyProfile.save() != null

        params.id = employeeCompetencyProfile.id

        def model = controller.edit()

        assert model.employeeCompetencyProfileInstance == employeeCompetencyProfile
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/employeeCompetencyProfile/list'

        response.reset()

        populateValidParams(params)
        def employeeCompetencyProfile = new EmployeeCompetencyProfile(params)

        assert employeeCompetencyProfile.save() != null

        // test invalid parameters in update
        params.id = employeeCompetencyProfile.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/employeeCompetencyProfile/edit"
        assert model.employeeCompetencyProfileInstance != null

        employeeCompetencyProfile.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/employeeCompetencyProfile/show/$employeeCompetencyProfile.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        employeeCompetencyProfile.clearErrors()

        populateValidParams(params)
        params.id = employeeCompetencyProfile.id
        params.version = -1
        controller.update()

        assert view == "/employeeCompetencyProfile/edit"
        assert model.employeeCompetencyProfileInstance != null
        assert model.employeeCompetencyProfileInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/employeeCompetencyProfile/list'

        response.reset()

        populateValidParams(params)
        def employeeCompetencyProfile = new EmployeeCompetencyProfile(params)

        assert employeeCompetencyProfile.save() != null
        assert EmployeeCompetencyProfile.count() == 1

        params.id = employeeCompetencyProfile.id

        controller.delete()

        assert EmployeeCompetencyProfile.count() == 0
        assert EmployeeCompetencyProfile.get(employeeCompetencyProfile.id) == null
        assert response.redirectedUrl == '/employeeCompetencyProfile/list'
    }
}
