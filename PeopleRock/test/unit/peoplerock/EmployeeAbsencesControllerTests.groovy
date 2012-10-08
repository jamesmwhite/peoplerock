package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(EmployeeAbsencesController)
@Mock(EmployeeAbsences)
class EmployeeAbsencesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/employeeAbsences/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.employeeAbsencesInstanceList.size() == 0
        assert model.employeeAbsencesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.employeeAbsencesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.employeeAbsencesInstance != null
        assert view == '/employeeAbsences/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/employeeAbsences/show/1'
        assert controller.flash.message != null
        assert EmployeeAbsences.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/employeeAbsences/list'

        populateValidParams(params)
        def employeeAbsences = new EmployeeAbsences(params)

        assert employeeAbsences.save() != null

        params.id = employeeAbsences.id

        def model = controller.show()

        assert model.employeeAbsencesInstance == employeeAbsences
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/employeeAbsences/list'

        populateValidParams(params)
        def employeeAbsences = new EmployeeAbsences(params)

        assert employeeAbsences.save() != null

        params.id = employeeAbsences.id

        def model = controller.edit()

        assert model.employeeAbsencesInstance == employeeAbsences
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/employeeAbsences/list'

        response.reset()

        populateValidParams(params)
        def employeeAbsences = new EmployeeAbsences(params)

        assert employeeAbsences.save() != null

        // test invalid parameters in update
        params.id = employeeAbsences.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/employeeAbsences/edit"
        assert model.employeeAbsencesInstance != null

        employeeAbsences.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/employeeAbsences/show/$employeeAbsences.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        employeeAbsences.clearErrors()

        populateValidParams(params)
        params.id = employeeAbsences.id
        params.version = -1
        controller.update()

        assert view == "/employeeAbsences/edit"
        assert model.employeeAbsencesInstance != null
        assert model.employeeAbsencesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/employeeAbsences/list'

        response.reset()

        populateValidParams(params)
        def employeeAbsences = new EmployeeAbsences(params)

        assert employeeAbsences.save() != null
        assert EmployeeAbsences.count() == 1

        params.id = employeeAbsences.id

        controller.delete()

        assert EmployeeAbsences.count() == 0
        assert EmployeeAbsences.get(employeeAbsences.id) == null
        assert response.redirectedUrl == '/employeeAbsences/list'
    }
}
