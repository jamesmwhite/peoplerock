<%@ page import="peoplerock.EmployeeHolidays" %>



<div class="fieldcontain ${hasErrors(bean: employeeHolidaysInstance, field: 'year', 'error')} required">
	<label for="year">
		<g:message code="employeeHolidays.year.label" default="Year" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="year" type="number" value="${employeeHolidaysInstance.year}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeHolidaysInstance, field: 'allocated', 'error')} required">
	<label for="allocated">
		<g:message code="employeeHolidays.allocated.label" default="Allocated" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="allocated" type="number" value="${employeeHolidaysInstance.allocated}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeHolidaysInstance, field: 'remaining', 'error')} required">
	<label for="remaining">
		<g:message code="employeeHolidays.remaining.label" default="Remaining" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="remaining" type="number" value="${employeeHolidaysInstance.remaining}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeHolidaysInstance, field: 'inLieu', 'error')} required">
	<label for="inLieu">
		<g:message code="employeeHolidays.inLieu.label" default="In Lieu" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="inLieu" type="number" value="${employeeHolidaysInstance.inLieu}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeHolidaysInstance, field: 'employee', 'error')} required">
	<label for="employee">
		<g:message code="employeeHolidays.employee.label" default="Employee" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="employee" name="employee.id" from="${peoplerock.Employee.list()}" optionKey="id" required="" value="${employeeHolidaysInstance?.employee?.id}" class="many-to-one"/>
</div>

