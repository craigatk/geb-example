<%@ page import="geb.example.Idea" %>



<div class="fieldcontain ${hasErrors(bean: ideaInstance, field: 'title', 'error')} required">
  <label for="title">
    <g:message code="idea.title.label" default="Title"/>
    <span class="required-indicator">*</span>
  </label>
  <g:textField name="title" maxlength="80" required="" value="${ideaInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ideaInstance, field: 'description', 'error')} required">
  <label for="description">
    <g:message code="idea.description.label" default="Description"/>
    <span class="required-indicator">*</span>
  </label>
  <g:textArea name="description" cols="40" rows="5" maxlength="1000" required="" value="${ideaInstance?.description}"/>
</div>

