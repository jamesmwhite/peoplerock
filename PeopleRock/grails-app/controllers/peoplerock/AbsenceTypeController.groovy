package peoplerock

import org.springframework.dao.DataIntegrityViolationException

class AbsenceTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [absenceTypeInstanceList: AbsenceType.list(params), absenceTypeInstanceTotal: AbsenceType.count()]
    }

    def create() {
        [absenceTypeInstance: new AbsenceType(params)]
    }

    def save() {
        def absenceTypeInstance = new AbsenceType(params)
        if (!absenceTypeInstance.save(flush: true)) {
            render(view: "create", model: [absenceTypeInstance: absenceTypeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'absenceType.label', default: 'AbsenceType'), absenceTypeInstance.id])
        redirect(action: "show", id: absenceTypeInstance.id)
    }

    def show(Long id) {
        def absenceTypeInstance = AbsenceType.get(id)
        if (!absenceTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'absenceType.label', default: 'AbsenceType'), id])
            redirect(action: "list")
            return
        }

        [absenceTypeInstance: absenceTypeInstance]
    }

    def edit(Long id) {
        def absenceTypeInstance = AbsenceType.get(id)
        if (!absenceTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'absenceType.label', default: 'AbsenceType'), id])
            redirect(action: "list")
            return
        }

        [absenceTypeInstance: absenceTypeInstance]
    }

    def update(Long id, Long version) {
        def absenceTypeInstance = AbsenceType.get(id)
        if (!absenceTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'absenceType.label', default: 'AbsenceType'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (absenceTypeInstance.version > version) {
                absenceTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'absenceType.label', default: 'AbsenceType')] as Object[],
                          "Another user has updated this AbsenceType while you were editing")
                render(view: "edit", model: [absenceTypeInstance: absenceTypeInstance])
                return
            }
        }

        absenceTypeInstance.properties = params

        if (!absenceTypeInstance.save(flush: true)) {
            render(view: "edit", model: [absenceTypeInstance: absenceTypeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'absenceType.label', default: 'AbsenceType'), absenceTypeInstance.id])
        redirect(action: "show", id: absenceTypeInstance.id)
    }

    def delete(Long id) {
        def absenceTypeInstance = AbsenceType.get(id)
        if (!absenceTypeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'absenceType.label', default: 'AbsenceType'), id])
            redirect(action: "list")
            return
        }

        try {
            absenceTypeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'absenceType.label', default: 'AbsenceType'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'absenceType.label', default: 'AbsenceType'), id])
            redirect(action: "show", id: id)
        }
    }
}
