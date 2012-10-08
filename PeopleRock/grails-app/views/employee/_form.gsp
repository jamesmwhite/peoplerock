<%@ page import="peoplerock.Employee" %>



<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="employee.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${employeeInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="employee.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${employeeInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'costCentre', 'error')} ">
	<label for="costCentre">
		<g:message code="employee.costCentre.label" default="Cost Centre" />
		
	</label>
	<g:textField name="costCentre" value="${employeeInstance?.costCentre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'hireDate', 'error')} required">
	<label for="hireDate">
		<g:message code="employee.hireDate.label" default="Hire Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="hireDate" precision="day"  value="${employeeInstance?.hireDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'employeeLeader', 'error')} ">
	<label for="employeeLeader">
		<g:message code="employee.employeeLeader.label" default="Employee Leader" />
		
	</label>
	<g:select id="employeeLeader" name="employeeLeader.id" from="${peoplerock.Employee.list()}" optionKey="id" value="${employeeInstance?.employeeLeader?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'employmentStatus', 'error')} required">
	<label for="employmentStatus">
		<g:message code="employee.employmentStatus.label" default="Employment Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="employmentStatus" from="${employeeInstance.constraints.employmentStatus.inList}" required="" value="${employeeInstance?.employmentStatus}" valueMessagePrefix="employee.employmentStatus"/>
</div>

