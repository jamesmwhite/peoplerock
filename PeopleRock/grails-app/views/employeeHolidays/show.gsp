
<%@ page import="peoplerock.EmployeeHolidays" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employeeHolidays.label', default: 'EmployeeHolidays')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-employeeHolidays" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-employeeHolidays" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list employeeHolidays">
			
				<g:if test="${employeeHolidaysInstance?.year}">
				<li class="fieldcontain">
					<span id="year-label" class="property-label"><g:message code="employeeHolidays.year.label" default="Year" /></span>
					
						<span class="property-value" aria-labelledby="year-label"><g:fieldValue bean="${employeeHolidaysInstance}" field="year"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeHolidaysInstance?.allocated}">
				<li class="fieldcontain">
					<span id="allocated-label" class="property-label"><g:message code="employeeHolidays.allocated.label" default="Allocated" /></span>
					
						<span class="property-value" aria-labelledby="allocated-label"><g:fieldValue bean="${employeeHolidaysInstance}" field="allocated"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeHolidaysInstance?.remaining}">
				<li class="fieldcontain">
					<span id="remaining-label" class="property-label"><g:message code="employeeHolidays.remaining.label" default="Remaining" /></span>
					
						<span class="property-value" aria-labelledby="remaining-label"><g:fieldValue bean="${employeeHolidaysInstance}" field="remaining"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeHolidaysInstance?.inLieu}">
				<li class="fieldcontain">
					<span id="inLieu-label" class="property-label"><g:message code="employeeHolidays.inLieu.label" default="In Lieu" /></span>
					
						<span class="property-value" aria-labelledby="inLieu-label"><g:fieldValue bean="${employeeHolidaysInstance}" field="inLieu"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeHolidaysInstance?.employee}">
				<li class="fieldcontain">
					<span id="employee-label" class="property-label"><g:message code="employeeHolidays.employee.label" default="Employee" /></span>
					
						<span class="property-value" aria-labelledby="employee-label"><g:link controller="employee" action="show" id="${employeeHolidaysInstance?.employee?.id}">${employeeHolidaysInstance?.employee?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${employeeHolidaysInstance?.id}" />
					<g:link class="edit" action="edit" id="${employeeHolidaysInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
