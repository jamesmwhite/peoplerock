package peoplerock

import org.springframework.dao.DataIntegrityViolationException

class EmployeeProfileController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [employeeProfileInstanceList: EmployeeProfile.list(params), employeeProfileInstanceTotal: EmployeeProfile.count()]
    }

    def create() {
        [employeeProfileInstance: new EmployeeProfile(params)]
    }

    def save() {
        def employeeProfileInstance = new EmployeeProfile(params)
        if (!employeeProfileInstance.save(flush: true)) {
            render(view: "create", model: [employeeProfileInstance: employeeProfileInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'employeeProfile.label', default: 'EmployeeProfile'), employeeProfileInstance.id])
        redirect(action: "show", id: employeeProfileInstance.id)
    }

    def show(Long id) {
        def employeeProfileInstance = EmployeeProfile.get(id)
        if (!employeeProfileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeProfile.label', default: 'EmployeeProfile'), id])
            redirect(action: "list")
            return
        }

        [employeeProfileInstance: employeeProfileInstance]
    }

    def edit(Long id) {
        def employeeProfileInstance = EmployeeProfile.get(id)
        if (!employeeProfileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeProfile.label', default: 'EmployeeProfile'), id])
            redirect(action: "list")
            return
        }

        [employeeProfileInstance: employeeProfileInstance]
    }

    def update(Long id, Long version) {
        def employeeProfileInstance = EmployeeProfile.get(id)
        if (!employeeProfileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeProfile.label', default: 'EmployeeProfile'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (employeeProfileInstance.version > version) {
                employeeProfileInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'employeeProfile.label', default: 'EmployeeProfile')] as Object[],
                          "Another user has updated this EmployeeProfile while you were editing")
                render(view: "edit", model: [employeeProfileInstance: employeeProfileInstance])
                return
            }
        }

        employeeProfileInstance.properties = params

        if (!employeeProfileInstance.save(flush: true)) {
            render(view: "edit", model: [employeeProfileInstance: employeeProfileInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'employeeProfile.label', default: 'EmployeeProfile'), employeeProfileInstance.id])
        redirect(action: "show", id: employeeProfileInstance.id)
    }

    def delete(Long id) {
        def employeeProfileInstance = EmployeeProfile.get(id)
        if (!employeeProfileInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeProfile.label', default: 'EmployeeProfile'), id])
            redirect(action: "list")
            return
        }

        try {
            employeeProfileInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'employeeProfile.label', default: 'EmployeeProfile'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'employeeProfile.label', default: 'EmployeeProfile'), id])
            redirect(action: "show", id: id)
        }
    }
}
