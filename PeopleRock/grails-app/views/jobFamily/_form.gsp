<%@ page import="peoplerock.JobFamily" %>



<div class="fieldcontain ${hasErrors(bean: jobFamilyInstance, field: 'jobFamilyName', 'error')} required">
	<label for="jobFamilyName">
		<g:message code="jobFamily.jobFamilyName.label" default="Job Family Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="jobFamilyName" required="" value="${jobFamilyInstance?.jobFamilyName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobFamilyInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="jobFamily.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${jobFamilyInstance?.description}"/>
</div>

