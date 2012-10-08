package peoplerock

import org.springframework.dao.DataIntegrityViolationException

class EmployeeHolidaysController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [employeeHolidaysInstanceList: EmployeeHolidays.list(params), employeeHolidaysInstanceTotal: EmployeeHolidays.count()]
    }

    def create() {
        [employeeHolidaysInstance: new EmployeeHolidays(params)]
    }

    def save() {
        def employeeHolidaysInstance = new EmployeeHolidays(params)
        if (!employeeHolidaysInstance.save(flush: true)) {
            render(view: "create", model: [employeeHolidaysInstance: employeeHolidaysInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'employeeHolidays.label', default: 'EmployeeHolidays'), employeeHolidaysInstance.id])
        redirect(action: "show", id: employeeHolidaysInstance.id)
    }

    def show(Long id) {
        def employeeHolidaysInstance = EmployeeHolidays.get(id)
        if (!employeeHolidaysInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeHolidays.label', default: 'EmployeeHolidays'), id])
            redirect(action: "list")
            return
        }

        [employeeHolidaysInstance: employeeHolidaysInstance]
    }

    def edit(Long id) {
        def employeeHolidaysInstance = EmployeeHolidays.get(id)
        if (!employeeHolidaysInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeHolidays.label', default: 'EmployeeHolidays'), id])
            redirect(action: "list")
            return
        }

        [employeeHolidaysInstance: employeeHolidaysInstance]
    }

    def update(Long id, Long version) {
        def employeeHolidaysInstance = EmployeeHolidays.get(id)
        if (!employeeHolidaysInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeHolidays.label', default: 'EmployeeHolidays'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (employeeHolidaysInstance.version > version) {
                employeeHolidaysInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'employeeHolidays.label', default: 'EmployeeHolidays')] as Object[],
                          "Another user has updated this EmployeeHolidays while you were editing")
                render(view: "edit", model: [employeeHolidaysInstance: employeeHolidaysInstance])
                return
            }
        }

        employeeHolidaysInstance.properties = params

        if (!employeeHolidaysInstance.save(flush: true)) {
            render(view: "edit", model: [employeeHolidaysInstance: employeeHolidaysInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'employeeHolidays.label', default: 'EmployeeHolidays'), employeeHolidaysInstance.id])
        redirect(action: "show", id: employeeHolidaysInstance.id)
    }

    def delete(Long id) {
        def employeeHolidaysInstance = EmployeeHolidays.get(id)
        if (!employeeHolidaysInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeHolidays.label', default: 'EmployeeHolidays'), id])
            redirect(action: "list")
            return
        }

        try {
            employeeHolidaysInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'employeeHolidays.label', default: 'EmployeeHolidays'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'employeeHolidays.label', default: 'EmployeeHolidays'), id])
            redirect(action: "show", id: id)
        }
    }
}
