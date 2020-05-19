package de.hybris.training.core.services.impl;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.training.core.daos.LegacyOrdersDao;
import de.hybris.training.core.model.LegacyOrderModel;
import de.hybris.training.core.services.LegacyOrderService;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

public class DefaultLegacyOrderService implements LegacyOrderService {

    LegacyOrdersDao legacyOrdersDao;

    @Override
    public SearchPageData<LegacyOrderModel> getOrders(CustomerModel customer, PageableData pageData) {
        validateParameterNotNull(customer, "Customer model cannot be null");
        validateParameterNotNull(pageData, "PageableData must not be null");
        return getLegacyOrdersDao().getOrdersByUser(customer,pageData);
    }

    @Override
    public LegacyOrderModel getOrderForCode(CustomerModel customer, String orderCode) {
        validateParameterNotNull(customer, "Customer model cannot be null");
        validateParameterNotNull(orderCode, "Order code cannot be null");
        return getLegacyOrdersDao().findOrderByCustomerAndCode(customer, orderCode);
    }

    public LegacyOrdersDao getLegacyOrdersDao() {
        return legacyOrdersDao;
    }

    public void setLegacyOrdersDao(LegacyOrdersDao legacyOrdersDao) {
        this.legacyOrdersDao = legacyOrdersDao;
    }
}
