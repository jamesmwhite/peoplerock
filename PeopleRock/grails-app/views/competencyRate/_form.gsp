<%@ page import="peoplerock.CompetencyRate" %>



<div class="fieldcontain ${hasErrors(bean: competencyRateInstance, field: 'shortDescription', 'error')} required">
	<label for="shortDescription">
		<g:message code="competencyRate.shortDescription.label" default="Short Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="shortDescription" required="" value="${competencyRateInstance?.shortDescription}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: competencyRateInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="competencyRate.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${competencyRateInstance?.description}"/>
</div>

