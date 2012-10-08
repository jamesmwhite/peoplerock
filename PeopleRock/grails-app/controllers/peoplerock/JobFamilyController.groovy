package peoplerock

import org.springframework.dao.DataIntegrityViolationException

class JobFamilyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [jobFamilyInstanceList: JobFamily.list(params), jobFamilyInstanceTotal: JobFamily.count()]
    }

    def create() {
        [jobFamilyInstance: new JobFamily(params)]
    }

    def save() {
        def jobFamilyInstance = new JobFamily(params)
        if (!jobFamilyInstance.save(flush: true)) {
            render(view: "create", model: [jobFamilyInstance: jobFamilyInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'jobFamily.label', default: 'JobFamily'), jobFamilyInstance.id])
        redirect(action: "show", id: jobFamilyInstance.id)
    }

    def show(Long id) {
        def jobFamilyInstance = JobFamily.get(id)
        if (!jobFamilyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'jobFamily.label', default: 'JobFamily'), id])
            redirect(action: "list")
            return
        }

        [jobFamilyInstance: jobFamilyInstance]
    }

    def edit(Long id) {
        def jobFamilyInstance = JobFamily.get(id)
        if (!jobFamilyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'jobFamily.label', default: 'JobFamily'), id])
            redirect(action: "list")
            return
        }

        [jobFamilyInstance: jobFamilyInstance]
    }

    def update(Long id, Long version) {
        def jobFamilyInstance = JobFamily.get(id)
        if (!jobFamilyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'jobFamily.label', default: 'JobFamily'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (jobFamilyInstance.version > version) {
                jobFamilyInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'jobFamily.label', default: 'JobFamily')] as Object[],
                          "Another user has updated this JobFamily while you were editing")
                render(view: "edit", model: [jobFamilyInstance: jobFamilyInstance])
                return
            }
        }

        jobFamilyInstance.properties = params

        if (!jobFamilyInstance.save(flush: true)) {
            render(view: "edit", model: [jobFamilyInstance: jobFamilyInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'jobFamily.label', default: 'JobFamily'), jobFamilyInstance.id])
        redirect(action: "show", id: jobFamilyInstance.id)
    }

    def delete(Long id) {
        def jobFamilyInstance = JobFamily.get(id)
        if (!jobFamilyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'jobFamily.label', default: 'JobFamily'), id])
            redirect(action: "list")
            return
        }

        try {
            jobFamilyInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'jobFamily.label', default: 'JobFamily'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'jobFamily.label', default: 'JobFamily'), id])
            redirect(action: "show", id: id)
        }
    }
}
