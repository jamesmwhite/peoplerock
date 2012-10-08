<%@ page import="peoplerock.TrainingAssignment" %>



<div class="fieldcontain ${hasErrors(bean: trainingAssignmentInstance, field: 'employee', 'error')} required">
	<label for="employee">
		<g:message code="trainingAssignment.employee.label" default="Employee" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="employee" name="employee.id" from="${peoplerock.Employee.list()}" optionKey="id" required="" value="${trainingAssignmentInstance?.employee?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: trainingAssignmentInstance, field: 'training', 'error')} required">
	<label for="training">
		<g:message code="trainingAssignment.training.label" default="Training" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="training" name="training.id" from="${peoplerock.Training.list()}" optionKey="id" required="" value="${trainingAssignmentInstance?.training?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: trainingAssignmentInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="trainingAssignment.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${trainingAssignmentInstance?.notes}"/>
</div>

