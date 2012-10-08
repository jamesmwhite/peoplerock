<%@ page import="peoplerock.JobPosition" %>



<div class="fieldcontain ${hasErrors(bean: jobPositionInstance, field: 'jobFamily', 'error')} required">
	<label for="jobFamily">
		<g:message code="jobPosition.jobFamily.label" default="Job Family" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="jobFamily" name="jobFamily.id" from="${peoplerock.JobFamily.list()}" optionKey="id" required="" value="${jobPositionInstance?.jobFamily?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobPositionInstance, field: 'role', 'error')} required">
	<label for="role">
		<g:message code="jobPosition.role.label" default="Role" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="role" name="role.id" from="${peoplerock.Role.list()}" optionKey="id" required="" value="${jobPositionInstance?.role?.id}" class="many-to-one"/>
</div>

