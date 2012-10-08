package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(AbsenceTypeController)
@Mock(AbsenceType)
class AbsenceTypeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/absenceType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.absenceTypeInstanceList.size() == 0
        assert model.absenceTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.absenceTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.absenceTypeInstance != null
        assert view == '/absenceType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/absenceType/show/1'
        assert controller.flash.message != null
        assert AbsenceType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/absenceType/list'

        populateValidParams(params)
        def absenceType = new AbsenceType(params)

        assert absenceType.save() != null

        params.id = absenceType.id

        def model = controller.show()

        assert model.absenceTypeInstance == absenceType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/absenceType/list'

        populateValidParams(params)
        def absenceType = new AbsenceType(params)

        assert absenceType.save() != null

        params.id = absenceType.id

        def model = controller.edit()

        assert model.absenceTypeInstance == absenceType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/absenceType/list'

        response.reset()

        populateValidParams(params)
        def absenceType = new AbsenceType(params)

        assert absenceType.save() != null

        // test invalid parameters in update
        params.id = absenceType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/absenceType/edit"
        assert model.absenceTypeInstance != null

        absenceType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/absenceType/show/$absenceType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        absenceType.clearErrors()

        populateValidParams(params)
        params.id = absenceType.id
        params.version = -1
        controller.update()

        assert view == "/absenceType/edit"
        assert model.absenceTypeInstance != null
        assert model.absenceTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/absenceType/list'

        response.reset()

        populateValidParams(params)
        def absenceType = new AbsenceType(params)

        assert absenceType.save() != null
        assert AbsenceType.count() == 1

        params.id = absenceType.id

        controller.delete()

        assert AbsenceType.count() == 0
        assert AbsenceType.get(absenceType.id) == null
        assert response.redirectedUrl == '/absenceType/list'
    }
}
