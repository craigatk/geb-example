package geb.example

import org.springframework.dao.DataIntegrityViolationException

class IdeaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    PatentService patentService

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [ideaInstanceList: Idea.list(params), ideaInstanceTotal: Idea.count()]
    }

    def create() {
        [ideaInstance: new Idea(params)]
    }

    def save() {
        def ideaInstance = new Idea(params)
        if (!ideaInstance.save(flush: true)) {
            render(view: "create", model: [ideaInstance: ideaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'idea.label', default: 'Idea'), ideaInstance.id])
        redirect(action: "show", id: ideaInstance.id)
    }

    def show(Long id) {
        def ideaInstance = Idea.get(id)
        if (!ideaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'idea.label', default: 'Idea'), id])
            redirect(action: "list")
            return
        }

        [ideaInstance: ideaInstance]
    }

    def edit(Long id) {
        def ideaInstance = Idea.get(id)
        if (!ideaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'idea.label', default: 'Idea'), id])
            redirect(action: "list")
            return
        }

        [ideaInstance: ideaInstance]
    }

    def update(Long id, Long version) {
        def ideaInstance = Idea.get(id)
        if (!ideaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'idea.label', default: 'Idea'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (ideaInstance.version > version) {
                ideaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'idea.label', default: 'Idea')] as Object[],
                          "Another user has updated this Idea while you were editing")
                render(view: "edit", model: [ideaInstance: ideaInstance])
                return
            }
        }

        ideaInstance.properties = params

        if (!ideaInstance.save(flush: true)) {
            render(view: "edit", model: [ideaInstance: ideaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'idea.label', default: 'Idea'), ideaInstance.id])
        redirect(action: "show", id: ideaInstance.id)
    }

    def delete(Long id) {
        def ideaInstance = Idea.get(id)
        if (!ideaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'idea.label', default: 'Idea'), id])
            redirect(action: "list")
            return
        }

        try {
            ideaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'idea.label', default: 'Idea'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'idea.label', default: 'Idea'), id])
            redirect(action: "show", id: id)
        }
    }

    def sendToPatentOffice(Long id) {
        Idea idea = Idea.get(id)

        patentService.sendToPatentOffice(idea)

        flash.message = 'Sent to patent office'

        redirect(action: 'show', params: [id: id])
    }
}
