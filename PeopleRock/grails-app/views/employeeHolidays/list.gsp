
<%@ page import="peoplerock.EmployeeHolidays" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employeeHolidays.label', default: 'EmployeeHolidays')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-employeeHolidays" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-employeeHolidays" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="year" title="${message(code: 'employeeHolidays.year.label', default: 'Year')}" />
					
						<g:sortableColumn property="allocated" title="${message(code: 'employeeHolidays.allocated.label', default: 'Allocated')}" />
					
						<g:sortableColumn property="remaining" title="${message(code: 'employeeHolidays.remaining.label', default: 'Remaining')}" />
					
						<g:sortableColumn property="inLieu" title="${message(code: 'employeeHolidays.inLieu.label', default: 'In Lieu')}" />
					
						<th><g:message code="employeeHolidays.employee.label" default="Employee" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${employeeHolidaysInstanceList}" status="i" var="employeeHolidaysInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${employeeHolidaysInstance.id}">${fieldValue(bean: employeeHolidaysInstance, field: "year")}</g:link></td>
					
						<td>${fieldValue(bean: employeeHolidaysInstance, field: "allocated")}</td>
					
						<td>${fieldValue(bean: employeeHolidaysInstance, field: "remaining")}</td>
					
						<td>${fieldValue(bean: employeeHolidaysInstance, field: "inLieu")}</td>
					
						<td>${fieldValue(bean: employeeHolidaysInstance, field: "employee")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${employeeHolidaysInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
