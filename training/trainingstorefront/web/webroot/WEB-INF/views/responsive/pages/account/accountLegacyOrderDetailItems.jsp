<%--
  Created by IntelliJ IDEA.
  User: josh
  Date: 5/14/20
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="order" tagdir="/WEB-INF/tags/responsive/order" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="account-orderdetail account-consignment">
    <ycommerce:testId code="orderDetail_itemList_section">
        <c:forEach items="${orderData.orderEntries}" var="consignment">
                <div class="productItemListHolder">
                    <order:accountLegacyOrderDetailsItem order="${orderData}"/>
                </div>
        </c:forEach>
    </ycommerce:testId>
</div>
