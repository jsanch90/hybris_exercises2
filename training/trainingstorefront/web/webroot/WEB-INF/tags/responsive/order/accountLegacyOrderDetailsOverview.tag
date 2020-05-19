<%--
  Created by IntelliJ IDEA.
  User: josh
  Date: 5/14/20
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="order" required="true" type="de.hybris.training.facades.legacyorders.data.LegacyOrderData" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<div class="order-detail-overview">
    <div class="row">
        <div class="col-sm-3">
            <div class="item-group">
                <ycommerce:testId code="orderDetail_overviewOrderID_label">
                    <span class="item-label"><spring:theme code="text.account.orderHistory.orderNumber"/></span>
                    <span class="item-value">${fn:escapeXml(orderData.orderNumber)}</span>
                </ycommerce:testId>
            </div>
        </div>
        <c:if test="${not empty orderData.orderStatus}">
            <div class="col-sm-3">
                <div class="item-group">
                    <ycommerce:testId code="orderDetail_overviewOrderStatus_label">
                        <span class="item-label"><spring:theme code="text.account.orderHistory.orderStatus"/></span>
                        <span class="item-value"><spring:theme code="text.account.legacy.order.status.display.${orderData.orderStatus}"/></span>
                    </ycommerce:testId>
                </div>
            </div>
        </c:if>
        <div class="col-sm-3">
            <div class="item-group">
                <ycommerce:testId code="orderDetail_overviewStatusDate_label">
                    <span class="item-label"><spring:theme code="text.account.orderHistory.datePlaced"/></span>
                    <span class="item-value"><fmt:formatDate value="${orderData.placed}" dateStyle="medium" timeStyle="short" type="both"/></span>
                </ycommerce:testId>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="item-group">
                <ycommerce:testId code="orderDetail_overviewOrderTotal_label">
                    <span class="item-label"><spring:theme code="text.account.order.total"/></span>
                    <span class="item-value">${orderData.orderTotal}</span>
                </ycommerce:testId>
            </div>
        </div>
    </div>
</div>
