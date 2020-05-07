package de.hybris.training.core.services;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.training.core.model.LegacyOrderModel;

public interface LegacyOrderService {
    SearchPageData<LegacyOrderModel> getOrders(CustomerModel customer, PageableData pageData);
}
