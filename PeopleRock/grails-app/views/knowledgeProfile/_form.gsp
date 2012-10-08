<%@ page import="peoplerock.KnowledgeProfile" %>



<div class="fieldcontain ${hasErrors(bean: knowledgeProfileInstance, field: 'employee', 'error')} required">
	<label for="employee">
		<g:message code="knowledgeProfile.employee.label" default="Employee" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="employee" name="employee.id" from="${peoplerock.Employee.list()}" optionKey="id" required="" value="${knowledgeProfileInstance?.employee?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: knowledgeProfileInstance, field: 'skill', 'error')} required">
	<label for="skill">
		<g:message code="knowledgeProfile.skill.label" default="Skill" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="skill" name="skill.id" from="${peoplerock.Skill.list()}" optionKey="id" required="" value="${knowledgeProfileInstance?.skill?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: knowledgeProfileInstance, field: 'level', 'error')} required">
	<label for="level">
		<g:message code="knowledgeProfile.level.label" default="Level" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="level" from="${peoplerock.Level?.values()}" keys="${peoplerock.Level.values()*.name()}" required="" value="${knowledgeProfileInstance?.level?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: knowledgeProfileInstance, field: 'note', 'error')} ">
	<label for="note">
		<g:message code="knowledgeProfile.note.label" default="Note" />
		
	</label>
	<g:textField name="note" value="${knowledgeProfileInstance?.note}"/>
</div>

