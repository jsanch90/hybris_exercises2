package de.hybris.training.core.daos.impl;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.commerceservices.search.flexiblesearch.PagedFlexibleSearchService;
import de.hybris.platform.commerceservices.search.flexiblesearch.data.SortQueryData;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.training.core.daos.LegacyOrdersDao;
import de.hybris.training.core.model.LegacyOrderModel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

public class DefaultLegacyOrdersDao extends AbstractItemDao implements LegacyOrdersDao {

    private PagedFlexibleSearchService pagedFlexibleSearchService;

    //Queries
    private static final String FIND_ORDERS_BY_CUSTOMER_AND_CODE = "SELECT {" + LegacyOrderModel.PK + "}, {"
            + LegacyOrderModel.CREATIONTIME + "}, {" + LegacyOrderModel.ORDERNUMBER + "} FROM {" + LegacyOrderModel._TYPECODE + "} WHERE {" + LegacyOrderModel.ORDERNUMBER
            + "} = ?code AND {" + LegacyOrderModel.CUSTOMER + "} = ?customer";

    private static final String LEGACY_ORDERS_BY_USER = "SELECT {" + LegacyOrderModel.PK + "}, {"
            + LegacyOrderModel.CREATIONTIME + "}, {" + LegacyOrderModel.ORDERNUMBER + "} FROM {"
            + LegacyOrderModel._TYPECODE + "} WHERE {" + LegacyOrderModel.CUSTOMER + "} = ?customer";

    private static final String SORT_ORDERS_BY_DATE = " ORDER BY {" + LegacyOrderModel.CREATIONTIME + "} DESC, {" + LegacyOrderModel.PK + "}";

    @Override
    public SearchPageData<LegacyOrderModel> getOrdersByUser(final CustomerModel customer, final PageableData pageData) {

        validateParameterNotNull(customer, "Customer must not be null");

        final Map<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("customer", customer);

        final List<SortQueryData> sortQueries;

        sortQueries = Arrays
                .asList(
                        createSortQueryData("byDate",
                                createQuery(LEGACY_ORDERS_BY_USER, SORT_ORDERS_BY_DATE)));


        return getPagedFlexibleSearchService().search(sortQueries, "byDate", queryParams, pageData);

    }

    @Override
    public LegacyOrderModel findOrderByCustomerAndCode(final CustomerModel customer, final String orderCode) {
        validateParameterNotNull(customer, "Customer must not be null");
        validateParameterNotNull(orderCode, "Code must not be null");
        final Map<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("customer", customer);
        queryParams.put("code", orderCode);
        final LegacyOrderModel result = getFlexibleSearchService().searchUnique(
                new FlexibleSearchQuery(FIND_ORDERS_BY_CUSTOMER_AND_CODE, queryParams));
        return result;
    }

    protected SortQueryData createSortQueryData(final String sortCode, final String query) {
        final SortQueryData result = new SortQueryData();
        result.setSortCode(sortCode);
        result.setQuery(query);
        return result;
    }

    protected String createQuery(final String... queryClauses) {
        final StringBuilder queryBuilder = new StringBuilder();

        for (final String queryClause : queryClauses) {
            queryBuilder.append(queryClause);
        }

        return queryBuilder.toString();
    }

    public PagedFlexibleSearchService getPagedFlexibleSearchService() {
        return pagedFlexibleSearchService;
    }

    public void setPagedFlexibleSearchService(PagedFlexibleSearchService pagedFlexibleSearchService) {
        this.pagedFlexibleSearchService = pagedFlexibleSearchService;
    }
}
