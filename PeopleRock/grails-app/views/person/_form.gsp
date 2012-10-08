<%@ page import="peoplerock.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="person.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${personInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="person.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${personInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'nickName', 'error')} ">
	<label for="nickName">
		<g:message code="person.nickName.label" default="Nick Name" />
		
	</label>
	<g:textField name="nickName" value="${personInstance?.nickName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'competencies', 'error')} ">
	<label for="competencies">
		<g:message code="person.competencies.label" default="Competencies" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.competencies?}" var="c">
    <li><g:link controller="personCompetency" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="personCompetency" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'personCompetency.label', default: 'PersonCompetency')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'skills', 'error')} ">
	<label for="skills">
		<g:message code="person.skills.label" default="Skills" />
		
	</label>
	<g:select name="skills" from="${peoplerock.Skill.list()}" multiple="multiple" optionKey="id" size="5" value="${personInstance?.skills*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'trainingcourses', 'error')} ">
	<label for="trainingcourses">
		<g:message code="person.trainingcourses.label" default="Trainingcourses" />
		
	</label>
	<g:select name="trainingcourses" from="${peoplerock.Training.list()}" multiple="multiple" optionKey="id" size="5" value="${personInstance?.trainingcourses*.id}" class="many-to-many"/>
</div>

