package peoplerock

import org.springframework.dao.DataIntegrityViolationException

class EmployeeAbsencesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [employeeAbsencesInstanceList: EmployeeAbsences.list(params), employeeAbsencesInstanceTotal: EmployeeAbsences.count()]
    }

    def create() {
        [employeeAbsencesInstance: new EmployeeAbsences(params)]
    }

    def save() {
        def employeeAbsencesInstance = new EmployeeAbsences(params)
        if (!employeeAbsencesInstance.save(flush: true)) {
            render(view: "create", model: [employeeAbsencesInstance: employeeAbsencesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'employeeAbsences.label', default: 'EmployeeAbsences'), employeeAbsencesInstance.id])
        redirect(action: "show", id: employeeAbsencesInstance.id)
    }

    def show(Long id) {
        def employeeAbsencesInstance = EmployeeAbsences.get(id)
        if (!employeeAbsencesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeAbsences.label', default: 'EmployeeAbsences'), id])
            redirect(action: "list")
            return
        }

        [employeeAbsencesInstance: employeeAbsencesInstance]
    }

    def edit(Long id) {
        def employeeAbsencesInstance = EmployeeAbsences.get(id)
        if (!employeeAbsencesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeAbsences.label', default: 'EmployeeAbsences'), id])
            redirect(action: "list")
            return
        }

        [employeeAbsencesInstance: employeeAbsencesInstance]
    }

    def update(Long id, Long version) {
        def employeeAbsencesInstance = EmployeeAbsences.get(id)
        if (!employeeAbsencesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeAbsences.label', default: 'EmployeeAbsences'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (employeeAbsencesInstance.version > version) {
                employeeAbsencesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'employeeAbsences.label', default: 'EmployeeAbsences')] as Object[],
                          "Another user has updated this EmployeeAbsences while you were editing")
                render(view: "edit", model: [employeeAbsencesInstance: employeeAbsencesInstance])
                return
            }
        }

        employeeAbsencesInstance.properties = params

        if (!employeeAbsencesInstance.save(flush: true)) {
            render(view: "edit", model: [employeeAbsencesInstance: employeeAbsencesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'employeeAbsences.label', default: 'EmployeeAbsences'), employeeAbsencesInstance.id])
        redirect(action: "show", id: employeeAbsencesInstance.id)
    }

    def delete(Long id) {
        def employeeAbsencesInstance = EmployeeAbsences.get(id)
        if (!employeeAbsencesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeAbsences.label', default: 'EmployeeAbsences'), id])
            redirect(action: "list")
            return
        }

        try {
            employeeAbsencesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'employeeAbsences.label', default: 'EmployeeAbsences'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'employeeAbsences.label', default: 'EmployeeAbsences'), id])
            redirect(action: "show", id: id)
        }
    }
}
