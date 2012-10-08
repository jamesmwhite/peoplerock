
<%@ page import="peoplerock.EmployeeProfile" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employeeProfile.label', default: 'EmployeeProfile')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-employeeProfile" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-employeeProfile" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="employeeProfile.employee.label" default="Employee" /></th>
					
						<th><g:message code="employeeProfile.jobPosition.label" default="Job Position" /></th>
					
						<g:sortableColumn property="startDate" title="${message(code: 'employeeProfile.startDate.label', default: 'Start Date')}" />
					
						<g:sortableColumn property="endDate" title="${message(code: 'employeeProfile.endDate.label', default: 'End Date')}" />
					
						<th><g:message code="employeeProfile.competencyProfile.label" default="Competency Profile" /></th>
					
						<g:sortableColumn property="careerTrack" title="${message(code: 'employeeProfile.careerTrack.label', default: 'Career Track')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${employeeProfileInstanceList}" status="i" var="employeeProfileInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${employeeProfileInstance.id}">${fieldValue(bean: employeeProfileInstance, field: "employee")}</g:link></td>
					
						<td>${fieldValue(bean: employeeProfileInstance, field: "jobPosition")}</td>
					
						<td><g:formatDate date="${employeeProfileInstance.startDate}" /></td>
					
						<td><g:formatDate date="${employeeProfileInstance.endDate}" /></td>
					
						<td>${fieldValue(bean: employeeProfileInstance, field: "competencyProfile")}</td>
					
						<td>${fieldValue(bean: employeeProfileInstance, field: "careerTrack")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${employeeProfileInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
