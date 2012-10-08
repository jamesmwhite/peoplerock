package peoplerock

import org.springframework.dao.DataIntegrityViolationException

class KnowledgeProfileController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [knowledgeProfileInstanceList: KnowledgeProfile.list(params), knowledgeProfileInstanceTotal: KnowledgeProfile.count()]
    }

    def create() {
        [knowledgeProfileInstance: new KnowledgeProfile(params)]
    }

    def save() {
        def knowledgeProfileInstance = new KnowledgeProfile(params)
        if (!knowledgeProfileInstance.save(flush: true)) {
            render(view: "create", model: [knowledgeProfileInstance: knowledgeProfileInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'knowledgeProfile.label', default: 'KnowledgeProfile'), knowledgeProfileInstance.id])
        redirect(action: "show", id: knowledgeProfileInstance.id)
    }

    def show(Long id) {
        def knowledgeProfileInstance = KnowledgeProfile.get(id)
        if (!knowledgeProfileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'knowledgeProfile.label', default: 'KnowledgeProfile'), id])
            redirect(action: "list")
            return
        }

        [knowledgeProfileInstance: knowledgeProfileInstance]
    }

    def edit(Long id) {
        def knowledgeProfileInstance = KnowledgeProfile.get(id)
        if (!knowledgeProfileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'knowledgeProfile.label', default: 'KnowledgeProfile'), id])
            redirect(action: "list")
            return
        }

        [knowledgeProfileInstance: knowledgeProfileInstance]
    }

    def update(Long id, Long version) {
        def knowledgeProfileInstance = KnowledgeProfile.get(id)
        if (!knowledgeProfileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'knowledgeProfile.label', default: 'KnowledgeProfile'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (knowledgeProfileInstance.version > version) {
                knowledgeProfileInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'knowledgeProfile.label', default: 'KnowledgeProfile')] as Object[],
                          "Another user has updated this KnowledgeProfile while you were editing")
                render(view: "edit", model: [knowledgeProfileInstance: knowledgeProfileInstance])
                return
            }
        }

        knowledgeProfileInstance.properties = params

        if (!knowledgeProfileInstance.save(flush: true)) {
            render(view: "edit", model: [knowledgeProfileInstance: knowledgeProfileInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'knowledgeProfile.label', default: 'KnowledgeProfile'), knowledgeProfileInstance.id])
        redirect(action: "show", id: knowledgeProfileInstance.id)
    }

    def delete(Long id) {
        def knowledgeProfileInstance = KnowledgeProfile.get(id)
        if (!knowledgeProfileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'knowledgeProfile.label', default: 'KnowledgeProfile'), id])
            redirect(action: "list")
            return
        }

        try {
            knowledgeProfileInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'knowledgeProfile.label', default: 'KnowledgeProfile'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'knowledgeProfile.label', default: 'KnowledgeProfile'), id])
            redirect(action: "show", id: id)
        }
    }
}
