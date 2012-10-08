
<%@ page import="peoplerock.Training" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'training.label', default: 'Training')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-training" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-training" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="courseName" title="${message(code: 'training.courseName.label', default: 'Course Name')}" />
					
						<g:sortableColumn property="startDate" title="${message(code: 'training.startDate.label', default: 'Start Date')}" />
					
						<g:sortableColumn property="finishDate" title="${message(code: 'training.finishDate.label', default: 'Finish Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trainingInstanceList}" status="i" var="trainingInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trainingInstance.id}">${fieldValue(bean: trainingInstance, field: "courseName")}</g:link></td>
					
						<td><g:formatDate date="${trainingInstance.startDate}" /></td>
					
						<td><g:formatDate date="${trainingInstance.finishDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${trainingInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
