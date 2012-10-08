package peoplerock

import org.springframework.dao.DataIntegrityViolationException

class ProjectAssignmentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [projectAssignmentInstanceList: ProjectAssignment.list(params), projectAssignmentInstanceTotal: ProjectAssignment.count()]
    }

    def create() {
        [projectAssignmentInstance: new ProjectAssignment(params)]
    }

    def save() {
        def projectAssignmentInstance = new ProjectAssignment(params)
        if (!projectAssignmentInstance.save(flush: true)) {
            render(view: "create", model: [projectAssignmentInstance: projectAssignmentInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'projectAssignment.label', default: 'ProjectAssignment'), projectAssignmentInstance.id])
        redirect(action: "show", id: projectAssignmentInstance.id)
    }

    def show(Long id) {
        def projectAssignmentInstance = ProjectAssignment.get(id)
        if (!projectAssignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'projectAssignment.label', default: 'ProjectAssignment'), id])
            redirect(action: "list")
            return
        }

        [projectAssignmentInstance: projectAssignmentInstance]
    }

    def edit(Long id) {
        def projectAssignmentInstance = ProjectAssignment.get(id)
        if (!projectAssignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'projectAssignment.label', default: 'ProjectAssignment'), id])
            redirect(action: "list")
            return
        }

        [projectAssignmentInstance: projectAssignmentInstance]
    }

    def update(Long id, Long version) {
        def projectAssignmentInstance = ProjectAssignment.get(id)
        if (!projectAssignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'projectAssignment.label', default: 'ProjectAssignment'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (projectAssignmentInstance.version > version) {
                projectAssignmentInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'projectAssignment.label', default: 'ProjectAssignment')] as Object[],
                          "Another user has updated this ProjectAssignment while you were editing")
                render(view: "edit", model: [projectAssignmentInstance: projectAssignmentInstance])
                return
            }
        }

        projectAssignmentInstance.properties = params

        if (!projectAssignmentInstance.save(flush: true)) {
            render(view: "edit", model: [projectAssignmentInstance: projectAssignmentInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'projectAssignment.label', default: 'ProjectAssignment'), projectAssignmentInstance.id])
        redirect(action: "show", id: projectAssignmentInstance.id)
    }

    def delete(Long id) {
        def projectAssignmentInstance = ProjectAssignment.get(id)
        if (!projectAssignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'projectAssignment.label', default: 'ProjectAssignment'), id])
            redirect(action: "list")
            return
        }

        try {
            projectAssignmentInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'projectAssignment.label', default: 'ProjectAssignment'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'projectAssignment.label', default: 'ProjectAssignment'), id])
            redirect(action: "show", id: id)
        }
    }
}
