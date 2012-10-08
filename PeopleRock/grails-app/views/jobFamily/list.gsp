
<%@ page import="peoplerock.JobFamily" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'jobFamily.label', default: 'JobFamily')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-jobFamily" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-jobFamily" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="jobFamilyName" title="${message(code: 'jobFamily.jobFamilyName.label', default: 'Job Family Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'jobFamily.description.label', default: 'Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${jobFamilyInstanceList}" status="i" var="jobFamilyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${jobFamilyInstance.id}">${fieldValue(bean: jobFamilyInstance, field: "jobFamilyName")}</g:link></td>
					
						<td>${fieldValue(bean: jobFamilyInstance, field: "description")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${jobFamilyInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
