<%@ page import="peoplerock.EmployeeAbsences" %>



<div class="fieldcontain ${hasErrors(bean: employeeAbsencesInstance, field: 'employee', 'error')} required">
	<label for="employee">
		<g:message code="employeeAbsences.employee.label" default="Employee" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="employee" name="employee.id" from="${peoplerock.Employee.list()}" optionKey="id" required="" value="${employeeAbsencesInstance?.employee?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeAbsencesInstance, field: 'absence', 'error')} required">
	<label for="absence">
		<g:message code="employeeAbsences.absence.label" default="Absence" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="absence" name="absence.id" from="${peoplerock.AbsenceType.list()}" optionKey="id" required="" value="${employeeAbsencesInstance?.absence?.id}" class="many-to-one"/>
</div>

