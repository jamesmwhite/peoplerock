package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(JobFamilyController)
@Mock(JobFamily)
class JobFamilyControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/jobFamily/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.jobFamilyInstanceList.size() == 0
        assert model.jobFamilyInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.jobFamilyInstance != null
    }

    void testSave() {
        controller.save()

        assert model.jobFamilyInstance != null
        assert view == '/jobFamily/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/jobFamily/show/1'
        assert controller.flash.message != null
        assert JobFamily.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/jobFamily/list'

        populateValidParams(params)
        def jobFamily = new JobFamily(params)

        assert jobFamily.save() != null

        params.id = jobFamily.id

        def model = controller.show()

        assert model.jobFamilyInstance == jobFamily
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/jobFamily/list'

        populateValidParams(params)
        def jobFamily = new JobFamily(params)

        assert jobFamily.save() != null

        params.id = jobFamily.id

        def model = controller.edit()

        assert model.jobFamilyInstance == jobFamily
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/jobFamily/list'

        response.reset()

        populateValidParams(params)
        def jobFamily = new JobFamily(params)

        assert jobFamily.save() != null

        // test invalid parameters in update
        params.id = jobFamily.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/jobFamily/edit"
        assert model.jobFamilyInstance != null

        jobFamily.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/jobFamily/show/$jobFamily.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        jobFamily.clearErrors()

        populateValidParams(params)
        params.id = jobFamily.id
        params.version = -1
        controller.update()

        assert view == "/jobFamily/edit"
        assert model.jobFamilyInstance != null
        assert model.jobFamilyInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/jobFamily/list'

        response.reset()

        populateValidParams(params)
        def jobFamily = new JobFamily(params)

        assert jobFamily.save() != null
        assert JobFamily.count() == 1

        params.id = jobFamily.id

        controller.delete()

        assert JobFamily.count() == 0
        assert JobFamily.get(jobFamily.id) == null
        assert response.redirectedUrl == '/jobFamily/list'
    }
}
