<%@ page import="geb.example.Idea" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="main">
  <g:set var="entityName" value="${message(code: 'idea.label', default: 'Idea')}"/>
  <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-idea" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
  <ul>
    <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
  </ul>
</div>

<div id="list-idea" class="content scaffold-list" role="main">
  <h1><g:message code="default.list.label" args="[entityName]"/></h1>
  <g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
  </g:if>
  <table id="ideaList">
    <thead>
    <tr>

      <g:sortableColumn property="title" title="${message(code: 'idea.title.label', default: 'Title')}"/>

      <g:sortableColumn property="description"
                        title="${message(code: 'idea.description.label', default: 'Description')}"/>

    </tr>
    </thead>
    <tbody>
    <g:each in="${ideaInstanceList}" status="i" var="ideaInstance">
      <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

        <td class="listTitleTest">
          <g:link action="show" id="${ideaInstance.id}">${fieldValue(bean: ideaInstance, field: "title")}</g:link>
        </td>

        <td class="listDescriptionTest">
          ${fieldValue(bean: ideaInstance, field: "description")}
        </td>

      </tr>
    </g:each>
    </tbody>
  </table>

  <div class="pagination">
    <g:paginate total="${ideaInstanceTotal}"/>
  </div>
</div>
</body>
</html>
