<%@ page import="peoplerock.Competencies" %>



<div class="fieldcontain ${hasErrors(bean: competenciesInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="competencies.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${competenciesInstance?.name}"/>
</div>

