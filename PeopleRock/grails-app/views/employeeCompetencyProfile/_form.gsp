<%@ page import="peoplerock.EmployeeCompetencyProfile" %>



<div class="fieldcontain ${hasErrors(bean: employeeCompetencyProfileInstance, field: 'competency', 'error')} required">
	<label for="competency">
		<g:message code="employeeCompetencyProfile.competency.label" default="Competency" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="competency" name="competency.id" from="${peoplerock.Competency.list()}" optionKey="id" required="" value="${employeeCompetencyProfileInstance?.competency?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeCompetencyProfileInstance, field: 'competencyRate', 'error')} required">
	<label for="competencyRate">
		<g:message code="employeeCompetencyProfile.competencyRate.label" default="Competency Rate" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="competencyRate" name="competencyRate.id" from="${peoplerock.CompetencyRate.list()}" optionKey="id" required="" value="${employeeCompetencyProfileInstance?.competencyRate?.id}" class="many-to-one"/>
</div>

