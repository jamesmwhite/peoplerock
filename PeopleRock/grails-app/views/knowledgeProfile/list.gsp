
<%@ page import="peoplerock.KnowledgeProfile" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'knowledgeProfile.label', default: 'KnowledgeProfile')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-knowledgeProfile" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-knowledgeProfile" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="knowledgeProfile.employee.label" default="Employee" /></th>
					
						<th><g:message code="knowledgeProfile.skill.label" default="Skill" /></th>
					
						<g:sortableColumn property="level" title="${message(code: 'knowledgeProfile.level.label', default: 'Level')}" />
					
						<g:sortableColumn property="note" title="${message(code: 'knowledgeProfile.note.label', default: 'Note')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${knowledgeProfileInstanceList}" status="i" var="knowledgeProfileInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${knowledgeProfileInstance.id}">${fieldValue(bean: knowledgeProfileInstance, field: "employee")}</g:link></td>
					
						<td>${fieldValue(bean: knowledgeProfileInstance, field: "skill")}</td>
					
						<td>${fieldValue(bean: knowledgeProfileInstance, field: "level")}</td>
					
						<td>${fieldValue(bean: knowledgeProfileInstance, field: "note")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${knowledgeProfileInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
