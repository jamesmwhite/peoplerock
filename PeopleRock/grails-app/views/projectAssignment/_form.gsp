<%@ page import="peoplerock.ProjectAssignment" %>



<div class="fieldcontain ${hasErrors(bean: projectAssignmentInstance, field: 'project', 'error')} required">
	<label for="project">
		<g:message code="projectAssignment.project.label" default="Project" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="project" name="project.id" from="${peoplerock.Project.list()}" optionKey="id" required="" value="${projectAssignmentInstance?.project?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectAssignmentInstance, field: 'employee', 'error')} required">
	<label for="employee">
		<g:message code="projectAssignment.employee.label" default="Employee" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="employee" name="employee.id" from="${peoplerock.Employee.list()}" optionKey="id" required="" value="${projectAssignmentInstance?.employee?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectAssignmentInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="projectAssignment.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${projectAssignmentInstance?.startDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: projectAssignmentInstance, field: 'endDate', 'error')} required">
	<label for="endDate">
		<g:message code="projectAssignment.endDate.label" default="End Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="endDate" precision="day"  value="${projectAssignmentInstance?.endDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: projectAssignmentInstance, field: 'endByDate', 'error')} required">
	<label for="endByDate">
		<g:message code="projectAssignment.endByDate.label" default="End By Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="endByDate" precision="day"  value="${projectAssignmentInstance?.endByDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: projectAssignmentInstance, field: 'allocated', 'error')} required">
	<label for="allocated">
		<g:message code="projectAssignment.allocated.label" default="Allocated" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="allocated" type="number" value="${projectAssignmentInstance.allocated}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectAssignmentInstance, field: 'demand', 'error')} required">
	<label for="demand">
		<g:message code="projectAssignment.demand.label" default="Demand" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="demand" type="number" value="${projectAssignmentInstance.demand}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectAssignmentInstance, field: 'coreTeamMember', 'error')} ">
	<label for="coreTeamMember">
		<g:message code="projectAssignment.coreTeamMember.label" default="Core Team Member" />
		
	</label>
	<g:checkBox name="coreTeamMember" value="${projectAssignmentInstance?.coreTeamMember}" />
</div>

