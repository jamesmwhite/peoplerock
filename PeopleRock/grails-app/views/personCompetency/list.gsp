
<%@ page import="peoplerock.PersonCompetency" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'personCompetency.label', default: 'PersonCompetency')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-personCompetency" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-personCompetency" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="personCompetency.competency.label" default="Competency" /></th>
					
						<g:sortableColumn property="level" title="${message(code: 'personCompetency.level.label', default: 'Level')}" />
					
						<th><g:message code="personCompetency.person.label" default="Person" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${personCompetencyInstanceList}" status="i" var="personCompetencyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${personCompetencyInstance.id}">${fieldValue(bean: personCompetencyInstance, field: "competency")}</g:link></td>
					
						<td>${fieldValue(bean: personCompetencyInstance, field: "level")}</td>
					
						<td>${fieldValue(bean: personCompetencyInstance, field: "person")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${personCompetencyInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
