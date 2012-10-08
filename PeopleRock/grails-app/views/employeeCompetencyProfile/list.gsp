
<%@ page import="peoplerock.EmployeeCompetencyProfile" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employeeCompetencyProfile.label', default: 'EmployeeCompetencyProfile')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-employeeCompetencyProfile" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-employeeCompetencyProfile" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="employeeCompetencyProfile.competency.label" default="Competency" /></th>
					
						<th><g:message code="employeeCompetencyProfile.competencyRate.label" default="Competency Rate" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${employeeCompetencyProfileInstanceList}" status="i" var="employeeCompetencyProfileInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${employeeCompetencyProfileInstance.id}">${fieldValue(bean: employeeCompetencyProfileInstance, field: "competency")}</g:link></td>
					
						<td>${fieldValue(bean: employeeCompetencyProfileInstance, field: "competencyRate")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${employeeCompetencyProfileInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
