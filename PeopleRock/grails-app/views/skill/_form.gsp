<%@ page import="peoplerock.Skill" %>



<div class="fieldcontain ${hasErrors(bean: skillInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="skill.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${skillInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: skillInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="skill.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${skillInstance?.description}"/>
</div>

