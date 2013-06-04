<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@attribute name="tagList" fragment="true" required="false"%>
<%@attribute name="information" type="br.com.caelum.brutal.model.Information" required="true" %>
<%@attribute name="index" type="java.lang.Integer" required="true" %>
<%@attribute name="type" type="java.lang.String" required="true" %>
<div class="history-forms-area ${index != 0 ? 'hidden' : ''}">
	<form method="post" class="history-form moderate-form" action="${linkTo[HistoryController].publish}${type}">
		<c:if test="${information.beforeCurrent}">
			<p class="alert"><fmt:message key="moderation.version_before_current"/></p>
		</c:if>
	
		<a href="#" class="toggle-version"><fmt:message key="moderation.formatted"/></a>
		<a href="#" class="toggle-version hidden"><fmt:message key="moderation.diff"/></a>
			<jsp:doBody/>
		<div class="history-diff post-text"></div>
		<div class="history-version"><jsp:invoke fragment="tagList"/></div>
		
	
		<ul class="post-touchs clear">
			<li class="touch author-touch">
				<tags:lastTouchFor touchable="${information.moderatable}"/>
			</li>
		</ul>
	
		<h2 class="history-title page-title"><fmt:message key="moderation.comment"/></h2>
		<p class="post-text">
			${information.comment}
		</p>
		
		<c:if test="${information.beforeCurrent}">
			<p class="alert"><fmt:message key="moderation.version_before_current"/></p>
		</c:if>
	
		<input type="hidden" name="aprovedInformationType" value="${information.typeName}"/>
		<input type="hidden" name="moderatableId" value="${information.moderatable.id}"/>
		<input type="hidden" name="aprovedInformationId" value="${information.id}"/>
		<input type="submit" class="post-submit big-submit" value='<fmt:message key="moderation.accept" />' />
	</form>
	<form method="post" action="${linkTo[HistoryController].reject[information.id][information.typeName]}">
		<input type="submit" class="post-submit big-submit" value='<fmt:message key="moderation.reject" />' />
	</form>
</div>