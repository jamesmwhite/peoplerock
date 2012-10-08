
<%@ page import="peoplerock.JobPosition" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'jobPosition.label', default: 'JobPosition')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-jobPosition" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-jobPosition" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="jobPosition.jobFamily.label" default="Job Family" /></th>
					
						<th><g:message code="jobPosition.role.label" default="Role" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${jobPositionInstanceList}" status="i" var="jobPositionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${jobPositionInstance.id}">${fieldValue(bean: jobPositionInstance, field: "jobFamily")}</g:link></td>
					
						<td>${fieldValue(bean: jobPositionInstance, field: "role")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${jobPositionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
