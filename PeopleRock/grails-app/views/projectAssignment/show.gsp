
<%@ page import="peoplerock.ProjectAssignment" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'projectAssignment.label', default: 'ProjectAssignment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-projectAssignment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-projectAssignment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list projectAssignment">
			
				<g:if test="${projectAssignmentInstance?.project}">
				<li class="fieldcontain">
					<span id="project-label" class="property-label"><g:message code="projectAssignment.project.label" default="Project" /></span>
					
						<span class="property-value" aria-labelledby="project-label"><g:link controller="project" action="show" id="${projectAssignmentInstance?.project?.id}">${projectAssignmentInstance?.project?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectAssignmentInstance?.employee}">
				<li class="fieldcontain">
					<span id="employee-label" class="property-label"><g:message code="projectAssignment.employee.label" default="Employee" /></span>
					
						<span class="property-value" aria-labelledby="employee-label"><g:link controller="employee" action="show" id="${projectAssignmentInstance?.employee?.id}">${projectAssignmentInstance?.employee?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectAssignmentInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="projectAssignment.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${projectAssignmentInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectAssignmentInstance?.endDate}">
				<li class="fieldcontain">
					<span id="endDate-label" class="property-label"><g:message code="projectAssignment.endDate.label" default="End Date" /></span>
					
						<span class="property-value" aria-labelledby="endDate-label"><g:formatDate date="${projectAssignmentInstance?.endDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectAssignmentInstance?.endByDate}">
				<li class="fieldcontain">
					<span id="endByDate-label" class="property-label"><g:message code="projectAssignment.endByDate.label" default="End By Date" /></span>
					
						<span class="property-value" aria-labelledby="endByDate-label"><g:formatDate date="${projectAssignmentInstance?.endByDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectAssignmentInstance?.allocated}">
				<li class="fieldcontain">
					<span id="allocated-label" class="property-label"><g:message code="projectAssignment.allocated.label" default="Allocated" /></span>
					
						<span class="property-value" aria-labelledby="allocated-label"><g:fieldValue bean="${projectAssignmentInstance}" field="allocated"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectAssignmentInstance?.demand}">
				<li class="fieldcontain">
					<span id="demand-label" class="property-label"><g:message code="projectAssignment.demand.label" default="Demand" /></span>
					
						<span class="property-value" aria-labelledby="demand-label"><g:fieldValue bean="${projectAssignmentInstance}" field="demand"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${projectAssignmentInstance?.coreTeamMember}">
				<li class="fieldcontain">
					<span id="coreTeamMember-label" class="property-label"><g:message code="projectAssignment.coreTeamMember.label" default="Core Team Member" /></span>
					
						<span class="property-value" aria-labelledby="coreTeamMember-label"><g:formatBoolean boolean="${projectAssignmentInstance?.coreTeamMember}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${projectAssignmentInstance?.id}" />
					<g:link class="edit" action="edit" id="${projectAssignmentInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
