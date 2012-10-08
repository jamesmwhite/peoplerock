<%@ page import="peoplerock.PersonCompetency" %>



<div class="fieldcontain ${hasErrors(bean: personCompetencyInstance, field: 'competency', 'error')} required">
	<label for="competency">
		<g:message code="personCompetency.competency.label" default="Competency" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="competency" name="competency.id" from="${peoplerock.Competencies.list()}" optionKey="id" required="" value="${personCompetencyInstance?.competency?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personCompetencyInstance, field: 'level', 'error')} required">
	<label for="level">
		<g:message code="personCompetency.level.label" default="Level" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="level" from="${peoplerock.Level?.values()}" keys="${peoplerock.Level.values()*.name()}" required="" value="${personCompetencyInstance?.level?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personCompetencyInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="personCompetency.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="person" name="person.id" from="${peoplerock.Person.list()}" optionKey="id" required="" value="${personCompetencyInstance?.person?.id}" class="many-to-one"/>
</div>

