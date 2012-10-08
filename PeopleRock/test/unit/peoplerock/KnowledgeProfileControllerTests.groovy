package peoplerock



import org.junit.*
import grails.test.mixin.*

@TestFor(KnowledgeProfileController)
@Mock(KnowledgeProfile)
class KnowledgeProfileControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/knowledgeProfile/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.knowledgeProfileInstanceList.size() == 0
        assert model.knowledgeProfileInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.knowledgeProfileInstance != null
    }

    void testSave() {
        controller.save()

        assert model.knowledgeProfileInstance != null
        assert view == '/knowledgeProfile/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/knowledgeProfile/show/1'
        assert controller.flash.message != null
        assert KnowledgeProfile.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/knowledgeProfile/list'

        populateValidParams(params)
        def knowledgeProfile = new KnowledgeProfile(params)

        assert knowledgeProfile.save() != null

        params.id = knowledgeProfile.id

        def model = controller.show()

        assert model.knowledgeProfileInstance == knowledgeProfile
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/knowledgeProfile/list'

        populateValidParams(params)
        def knowledgeProfile = new KnowledgeProfile(params)

        assert knowledgeProfile.save() != null

        params.id = knowledgeProfile.id

        def model = controller.edit()

        assert model.knowledgeProfileInstance == knowledgeProfile
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/knowledgeProfile/list'

        response.reset()

        populateValidParams(params)
        def knowledgeProfile = new KnowledgeProfile(params)

        assert knowledgeProfile.save() != null

        // test invalid parameters in update
        params.id = knowledgeProfile.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/knowledgeProfile/edit"
        assert model.knowledgeProfileInstance != null

        knowledgeProfile.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/knowledgeProfile/show/$knowledgeProfile.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        knowledgeProfile.clearErrors()

        populateValidParams(params)
        params.id = knowledgeProfile.id
        params.version = -1
        controller.update()

        assert view == "/knowledgeProfile/edit"
        assert model.knowledgeProfileInstance != null
        assert model.knowledgeProfileInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/knowledgeProfile/list'

        response.reset()

        populateValidParams(params)
        def knowledgeProfile = new KnowledgeProfile(params)

        assert knowledgeProfile.save() != null
        assert KnowledgeProfile.count() == 1

        params.id = knowledgeProfile.id

        controller.delete()

        assert KnowledgeProfile.count() == 0
        assert KnowledgeProfile.get(knowledgeProfile.id) == null
        assert response.redirectedUrl == '/knowledgeProfile/list'
    }
}
