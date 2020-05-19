<%--
  Created by IntelliJ IDEA.
  User: josh
  Date: 5/14/20
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="order" required="true" type="de.hybris.training.facades.legacyorders.data.LegacyOrderData" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="order" tagdir="/WEB-INF/tags/responsive/order" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<spring:htmlEscape defaultHtmlEscape="true" />
<ul class="item__list">
    <li class="hidden-xs hidden-sm">
        <ul class="item__list--header">
            <li class="item__toggle"></li>
            <li class="item__image"></li>
            <li class="item__info"><spring:theme code="basket.page.item"/></li>
            <li class="item__price"><spring:theme code="basket.page.price"/></li>
            <li class="item__quantity"><spring:theme code="basket.page.qty"/></li>
            <li class="item__total--column"><spring:theme code="basket.page.total"/></li>
        </ul>
    </li>
    <ycommerce:testId code="orderDetail_itemBody_section">
        <c:forEach items="${order.orderEntries}" var="entry" varStatus="loop">
            <order:legacyOrderEntryDetails orderEntry="${entry}" order="${order}" itemIndex="${loop.index}"/>
        </c:forEach>
    </ycommerce:testId>
</ul>