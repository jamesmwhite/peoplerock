package peoplerock

import org.springframework.dao.DataIntegrityViolationException

class EmployeeCompetencyProfileController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [employeeCompetencyProfileInstanceList: EmployeeCompetencyProfile.list(params), employeeCompetencyProfileInstanceTotal: EmployeeCompetencyProfile.count()]
    }

    def create() {
        [employeeCompetencyProfileInstance: new EmployeeCompetencyProfile(params)]
    }

    def save() {
        def employeeCompetencyProfileInstance = new EmployeeCompetencyProfile(params)
        if (!employeeCompetencyProfileInstance.save(flush: true)) {
            render(view: "create", model: [employeeCompetencyProfileInstance: employeeCompetencyProfileInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'employeeCompetencyProfile.label', default: 'EmployeeCompetencyProfile'), employeeCompetencyProfileInstance.id])
        redirect(action: "show", id: employeeCompetencyProfileInstance.id)
    }

    def show(Long id) {
        def employeeCompetencyProfileInstance = EmployeeCompetencyProfile.get(id)
        if (!employeeCompetencyProfileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeCompetencyProfile.label', default: 'EmployeeCompetencyProfile'), id])
            redirect(action: "list")
            return
        }

        [employeeCompetencyProfileInstance: employeeCompetencyProfileInstance]
    }

    def edit(Long id) {
        def employeeCompetencyProfileInstance = EmployeeCompetencyProfile.get(id)
        if (!employeeCompetencyProfileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeCompetencyProfile.label', default: 'EmployeeCompetencyProfile'), id])
            redirect(action: "list")
            return
        }

        [employeeCompetencyProfileInstance: employeeCompetencyProfileInstance]
    }

    def update(Long id, Long version) {
        def employeeCompetencyProfileInstance = EmployeeCompetencyProfile.get(id)
        if (!employeeCompetencyProfileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeCompetencyProfile.label', default: 'EmployeeCompetencyProfile'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (employeeCompetencyProfileInstance.version > version) {
                employeeCompetencyProfileInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'employeeCompetencyProfile.label', default: 'EmployeeCompetencyProfile')] as Object[],
                          "Another user has updated this EmployeeCompetencyProfile while you were editing")
                render(view: "edit", model: [employeeCompetencyProfileInstance: employeeCompetencyProfileInstance])
                return
            }
        }

        employeeCompetencyProfileInstance.properties = params

        if (!employeeCompetencyProfileInstance.save(flush: true)) {
            render(view: "edit", model: [employeeCompetencyProfileInstance: employeeCompetencyProfileInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'employeeCompetencyProfile.label', default: 'EmployeeCompetencyProfile'), employeeCompetencyProfileInstance.id])
        redirect(action: "show", id: employeeCompetencyProfileInstance.id)
    }

    def delete(Long id) {
        def employeeCompetencyProfileInstance = EmployeeCompetencyProfile.get(id)
        if (!employeeCompetencyProfileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeCompetencyProfile.label', default: 'EmployeeCompetencyProfile'), id])
            redirect(action: "list")
            return
        }

        try {
            employeeCompetencyProfileInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'employeeCompetencyProfile.label', default: 'EmployeeCompetencyProfile'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'employeeCompetencyProfile.label', default: 'EmployeeCompetencyProfile'), id])
            redirect(action: "show", id: id)
        }
    }
}
