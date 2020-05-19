<%--
  Created by IntelliJ IDEA.
  User: josh
  Date: 5/14/20
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-account/legacy_orders" var="orderHistoryUrl" htmlEscape="false"/>

<div class="row">
    <div class="col-xs-12 col-sm-6 col-md-5 col-lg-4 pull-right">
        <ycommerce:testId code="orderDetails_backToOrderHistory_button">
            <div class="orderBackBtn">
                <button type="button" class="btn btn-default btn-block" data-back-to-orders="${fn:escapeXml(orderHistoryUrl)}">
                    <spring:theme code="text.account.legacy.orderDetails.backToOrderHistory"/>
                </button>
            </div>
        </ycommerce:testId>
    </div>
</div>
