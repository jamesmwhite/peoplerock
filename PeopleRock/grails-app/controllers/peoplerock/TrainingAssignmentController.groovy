package peoplerock

import org.springframework.dao.DataIntegrityViolationException

class TrainingAssignmentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [trainingAssignmentInstanceList: TrainingAssignment.list(params), trainingAssignmentInstanceTotal: TrainingAssignment.count()]
    }

    def create() {
        [trainingAssignmentInstance: new TrainingAssignment(params)]
    }

    def save() {
        def trainingAssignmentInstance = new TrainingAssignment(params)
        if (!trainingAssignmentInstance.save(flush: true)) {
            render(view: "create", model: [trainingAssignmentInstance: trainingAssignmentInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'trainingAssignment.label', default: 'TrainingAssignment'), trainingAssignmentInstance.id])
        redirect(action: "show", id: trainingAssignmentInstance.id)
    }

    def show(Long id) {
        def trainingAssignmentInstance = TrainingAssignment.get(id)
        if (!trainingAssignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trainingAssignment.label', default: 'TrainingAssignment'), id])
            redirect(action: "list")
            return
        }

        [trainingAssignmentInstance: trainingAssignmentInstance]
    }

    def edit(Long id) {
        def trainingAssignmentInstance = TrainingAssignment.get(id)
        if (!trainingAssignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trainingAssignment.label', default: 'TrainingAssignment'), id])
            redirect(action: "list")
            return
        }

        [trainingAssignmentInstance: trainingAssignmentInstance]
    }

    def update(Long id, Long version) {
        def trainingAssignmentInstance = TrainingAssignment.get(id)
        if (!trainingAssignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trainingAssignment.label', default: 'TrainingAssignment'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (trainingAssignmentInstance.version > version) {
                trainingAssignmentInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'trainingAssignment.label', default: 'TrainingAssignment')] as Object[],
                          "Another user has updated this TrainingAssignment while you were editing")
                render(view: "edit", model: [trainingAssignmentInstance: trainingAssignmentInstance])
                return
            }
        }

        trainingAssignmentInstance.properties = params

        if (!trainingAssignmentInstance.save(flush: true)) {
            render(view: "edit", model: [trainingAssignmentInstance: trainingAssignmentInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'trainingAssignment.label', default: 'TrainingAssignment'), trainingAssignmentInstance.id])
        redirect(action: "show", id: trainingAssignmentInstance.id)
    }

    def delete(Long id) {
        def trainingAssignmentInstance = TrainingAssignment.get(id)
        if (!trainingAssignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trainingAssignment.label', default: 'TrainingAssignment'), id])
            redirect(action: "list")
            return
        }

        try {
            trainingAssignmentInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'trainingAssignment.label', default: 'TrainingAssignment'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'trainingAssignment.label', default: 'TrainingAssignment'), id])
            redirect(action: "show", id: id)
        }
    }
}
