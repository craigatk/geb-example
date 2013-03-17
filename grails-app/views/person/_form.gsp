<%@ page import="geb.example.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="person.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${personInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'middleInitial', 'error')} ">
	<label for="middleInitial">
		<g:message code="person.middleInitial.label" default="Middle Initial" />
		
	</label>
	<g:textField name="middleInitial" value="${personInstance?.middleInitial}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="person.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${personInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'streetAddress', 'error')} required">
	<label for="streetAddress">
		<g:message code="person.streetAddress.label" default="Street Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="streetAddress" required="" value="${personInstance?.streetAddress}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'streetAddress2', 'error')} ">
	<label for="streetAddress2">
		<g:message code="person.streetAddress2.label" default="Street Address2" />
		
	</label>
	<g:textField name="streetAddress2" value="${personInstance?.streetAddress2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="person.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="city" required="" value="${personInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'state', 'error')} required">
	<label for="state">
		<g:message code="person.state.label" default="State" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="state" required="" value="${personInstance?.state}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'zipCode', 'error')} required">
	<label for="zipCode">
		<g:message code="person.zipCode.label" default="Zip Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="zipCode" required="" value="${personInstance?.zipCode}"/>
</div>

