
<%@ page import="peoplerock.PersonCompetency" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'personCompetency.label', default: 'PersonCompetency')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-personCompetency" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-personCompetency" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list personCompetency">
			
				<g:if test="${personCompetencyInstance?.competency}">
				<li class="fieldcontain">
					<span id="competency-label" class="property-label"><g:message code="personCompetency.competency.label" default="Competency" /></span>
					
						<span class="property-value" aria-labelledby="competency-label"><g:link controller="competencies" action="show" id="${personCompetencyInstance?.competency?.id}">${personCompetencyInstance?.competency?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personCompetencyInstance?.level}">
				<li class="fieldcontain">
					<span id="level-label" class="property-label"><g:message code="personCompetency.level.label" default="Level" /></span>
					
						<span class="property-value" aria-labelledby="level-label"><g:fieldValue bean="${personCompetencyInstance}" field="level"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personCompetencyInstance?.person}">
				<li class="fieldcontain">
					<span id="person-label" class="property-label"><g:message code="personCompetency.person.label" default="Person" /></span>
					
						<span class="property-value" aria-labelledby="person-label"><g:link controller="person" action="show" id="${personCompetencyInstance?.person?.id}">${personCompetencyInstance?.person?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${personCompetencyInstance?.id}" />
					<g:link class="edit" action="edit" id="${personCompetencyInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
