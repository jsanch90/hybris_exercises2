package de.hybris.training.core.daos;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.internal.dao.Dao;

public interface LegacyOrdersDao extends Dao {

    public SearchPageData<Object> getOrdersByUser(CustomerModel customer, PageableData pageData);
}
