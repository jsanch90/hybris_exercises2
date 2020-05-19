<%--
  Created by IntelliJ IDEA.
  User: josh
  Date: 5/14/20
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="order" tagdir="/WEB-INF/tags/responsive/order" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="well well-tertiary well-lg">
    <ycommerce:testId code="orderDetail_overview_section">
        <order:accountLegacyOrderDetailsOverview order="${orderData}"/>
    </ycommerce:testId>
</div>


