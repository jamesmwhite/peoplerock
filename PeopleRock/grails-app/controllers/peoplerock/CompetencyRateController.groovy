package peoplerock

import org.springframework.dao.DataIntegrityViolationException

class CompetencyRateController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [competencyRateInstanceList: CompetencyRate.list(params), competencyRateInstanceTotal: CompetencyRate.count()]
    }

    def create() {
        [competencyRateInstance: new CompetencyRate(params)]
    }

    def save() {
        def competencyRateInstance = new CompetencyRate(params)
        if (!competencyRateInstance.save(flush: true)) {
            render(view: "create", model: [competencyRateInstance: competencyRateInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'competencyRate.label', default: 'CompetencyRate'), competencyRateInstance.id])
        redirect(action: "show", id: competencyRateInstance.id)
    }

    def show(Long id) {
        def competencyRateInstance = CompetencyRate.get(id)
        if (!competencyRateInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'competencyRate.label', default: 'CompetencyRate'), id])
            redirect(action: "list")
            return
        }

        [competencyRateInstance: competencyRateInstance]
    }

    def edit(Long id) {
        def competencyRateInstance = CompetencyRate.get(id)
        if (!competencyRateInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'competencyRate.label', default: 'CompetencyRate'), id])
            redirect(action: "list")
            return
        }

        [competencyRateInstance: competencyRateInstance]
    }

    def update(Long id, Long version) {
        def competencyRateInstance = CompetencyRate.get(id)
        if (!competencyRateInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'competencyRate.label', default: 'CompetencyRate'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (competencyRateInstance.version > version) {
                competencyRateInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'competencyRate.label', default: 'CompetencyRate')] as Object[],
                          "Another user has updated this CompetencyRate while you were editing")
                render(view: "edit", model: [competencyRateInstance: competencyRateInstance])
                return
            }
        }

        competencyRateInstance.properties = params

        if (!competencyRateInstance.save(flush: true)) {
            render(view: "edit", model: [competencyRateInstance: competencyRateInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'competencyRate.label', default: 'CompetencyRate'), competencyRateInstance.id])
        redirect(action: "show", id: competencyRateInstance.id)
    }

    def delete(Long id) {
        def competencyRateInstance = CompetencyRate.get(id)
        if (!competencyRateInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'competencyRate.label', default: 'CompetencyRate'), id])
            redirect(action: "list")
            return
        }

        try {
            competencyRateInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'competencyRate.label', default: 'CompetencyRate'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'competencyRate.label', default: 'CompetencyRate'), id])
            redirect(action: "show", id: id)
        }
    }
}
