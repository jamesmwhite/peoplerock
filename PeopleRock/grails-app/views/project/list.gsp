
<%@ page import="peoplerock.Project" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-project" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-project" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="projectName" title="${message(code: 'project.projectName.label', default: 'Project Name')}" />
					
						<th><g:message code="project.platform.label" default="Platform" /></th>
					
						<th><g:message code="project.owner.label" default="Owner" /></th>
					
						<g:sortableColumn property="startDate" title="${message(code: 'project.startDate.label', default: 'Start Date')}" />
					
						<g:sortableColumn property="endByDate" title="${message(code: 'project.endByDate.label', default: 'End By Date')}" />
					
						<g:sortableColumn property="finishDate" title="${message(code: 'project.finishDate.label', default: 'Finish Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${projectInstanceList}" status="i" var="projectInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${projectInstance.id}">${fieldValue(bean: projectInstance, field: "projectName")}</g:link></td>
					
						<td>${fieldValue(bean: projectInstance, field: "platform")}</td>
					
						<td>${fieldValue(bean: projectInstance, field: "owner")}</td>
					
						<td><g:formatDate date="${projectInstance.startDate}" /></td>
					
						<td><g:formatDate date="${projectInstance.endByDate}" /></td>
					
						<td><g:formatDate date="${projectInstance.finishDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${projectInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
