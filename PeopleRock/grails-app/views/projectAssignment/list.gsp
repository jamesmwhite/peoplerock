
<%@ page import="peoplerock.ProjectAssignment" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'projectAssignment.label', default: 'ProjectAssignment')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-projectAssignment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-projectAssignment" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="projectAssignment.project.label" default="Project" /></th>
					
						<th><g:message code="projectAssignment.employee.label" default="Employee" /></th>
					
						<g:sortableColumn property="startDate" title="${message(code: 'projectAssignment.startDate.label', default: 'Start Date')}" />
					
						<g:sortableColumn property="endDate" title="${message(code: 'projectAssignment.endDate.label', default: 'End Date')}" />
					
						<g:sortableColumn property="endByDate" title="${message(code: 'projectAssignment.endByDate.label', default: 'End By Date')}" />
					
						<g:sortableColumn property="allocated" title="${message(code: 'projectAssignment.allocated.label', default: 'Allocated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${projectAssignmentInstanceList}" status="i" var="projectAssignmentInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${projectAssignmentInstance.id}">${fieldValue(bean: projectAssignmentInstance, field: "project")}</g:link></td>
					
						<td>${fieldValue(bean: projectAssignmentInstance, field: "employee")}</td>
					
						<td><g:formatDate date="${projectAssignmentInstance.startDate}" /></td>
					
						<td><g:formatDate date="${projectAssignmentInstance.endDate}" /></td>
					
						<td><g:formatDate date="${projectAssignmentInstance.endByDate}" /></td>
					
						<td>${fieldValue(bean: projectAssignmentInstance, field: "allocated")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${projectAssignmentInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
