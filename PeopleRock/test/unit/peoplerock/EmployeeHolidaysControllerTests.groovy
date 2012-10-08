package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(EmployeeHolidaysController)
@Mock(EmployeeHolidays)
class EmployeeHolidaysControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/employeeHolidays/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.employeeHolidaysInstanceList.size() == 0
        assert model.employeeHolidaysInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.employeeHolidaysInstance != null
    }

    void testSave() {
        controller.save()

        assert model.employeeHolidaysInstance != null
        assert view == '/employeeHolidays/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/employeeHolidays/show/1'
        assert controller.flash.message != null
        assert EmployeeHolidays.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/employeeHolidays/list'

        populateValidParams(params)
        def employeeHolidays = new EmployeeHolidays(params)

        assert employeeHolidays.save() != null

        params.id = employeeHolidays.id

        def model = controller.show()

        assert model.employeeHolidaysInstance == employeeHolidays
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/employeeHolidays/list'

        populateValidParams(params)
        def employeeHolidays = new EmployeeHolidays(params)

        assert employeeHolidays.save() != null

        params.id = employeeHolidays.id

        def model = controller.edit()

        assert model.employeeHolidaysInstance == employeeHolidays
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/employeeHolidays/list'

        response.reset()

        populateValidParams(params)
        def employeeHolidays = new EmployeeHolidays(params)

        assert employeeHolidays.save() != null

        // test invalid parameters in update
        params.id = employeeHolidays.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/employeeHolidays/edit"
        assert model.employeeHolidaysInstance != null

        employeeHolidays.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/employeeHolidays/show/$employeeHolidays.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        employeeHolidays.clearErrors()

        populateValidParams(params)
        params.id = employeeHolidays.id
        params.version = -1
        controller.update()

        assert view == "/employeeHolidays/edit"
        assert model.employeeHolidaysInstance != null
        assert model.employeeHolidaysInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/employeeHolidays/list'

        response.reset()

        populateValidParams(params)
        def employeeHolidays = new EmployeeHolidays(params)

        assert employeeHolidays.save() != null
        assert EmployeeHolidays.count() == 1

        params.id = employeeHolidays.id

        controller.delete()

        assert EmployeeHolidays.count() == 0
        assert EmployeeHolidays.get(employeeHolidays.id) == null
        assert response.redirectedUrl == '/employeeHolidays/list'
    }
}
