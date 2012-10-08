<%@ page import="peoplerock.AbsenceType" %>



<div class="fieldcontain ${hasErrors(bean: absenceTypeInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="absenceType.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="description" from="${absenceTypeInstance.constraints.description.inList}" required="" value="${absenceTypeInstance?.description}" valueMessagePrefix="absenceType.description"/>
</div>

