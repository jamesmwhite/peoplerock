<%@ page import="peoplerock.Competency" %>



<div class="fieldcontain ${hasErrors(bean: competencyInstance, field: 'shortDescription', 'error')} required">
	<label for="shortDescription">
		<g:message code="competency.shortDescription.label" default="Short Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="shortDescription" required="" value="${competencyInstance?.shortDescription}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: competencyInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="competency.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${competencyInstance?.description}"/>
</div>

