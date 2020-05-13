package de.hybris.training.facades.facades;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.training.facades.legacyorders.data.LegacyOrderData;

public interface LegacyOrderFacade {

    SearchPageData<LegacyOrderData> getPagedLegacyOrderHistory(PageableData pageableData);

}
