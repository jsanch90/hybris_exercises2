<%--
  Created by IntelliJ IDEA.
  User: josh
  Date: 5/14/20
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account/legacy_orders" var="legacyOrderHistoryUrl" htmlEscape="false"/>
<common:headline url="${legacyOrderHistoryUrl}" labelKey="text.account.legacy.order.title.details" />

