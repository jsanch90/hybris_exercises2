package de.hybris.training.core.daos;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.internal.dao.Dao;
import de.hybris.training.core.model.LegacyOrderModel;

public interface LegacyOrdersDao extends Dao {

    public SearchPageData<LegacyOrderModel> getOrdersByUser(CustomerModel customer, PageableData pageData);
}
