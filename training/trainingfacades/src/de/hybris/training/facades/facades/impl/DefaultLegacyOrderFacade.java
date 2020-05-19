package de.hybris.training.facades.facades.impl;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.training.core.model.LegacyOrderModel;
import de.hybris.training.core.services.LegacyOrderService;
import de.hybris.training.facades.facades.LegacyOrderFacade;
import de.hybris.training.facades.legacyorders.data.LegacyOrderData;

@SuppressWarnings("removal")
public class DefaultLegacyOrderFacade implements LegacyOrderFacade {

    private static final String ORDER_NOT_FOUND_FOR_USER = "Order with guid %s not found for current user";

    private UserService userService;
    private LegacyOrderService legacyOrderService;
    private Converter<LegacyOrderModel,LegacyOrderData> legacyOrderConverter;

    @Override
    public SearchPageData<LegacyOrderData> getPagedLegacyOrderHistory(PageableData pageableData) {
        CustomerModel currentUser = (CustomerModel) getUserService().getCurrentUser();
        final SearchPageData<LegacyOrderModel> legacyOrderResults = getLegacyOrderService().getOrders(currentUser,pageableData);
        return convertPageData(legacyOrderResults,getLegacyOrderConverter());
    }

    @Override
    public LegacyOrderData getOrderDetailsForCode(String orderCode) {

        LegacyOrderModel legacyOrderModel = null;
        try
        {
            legacyOrderModel = getLegacyOrderService().getOrderForCode((CustomerModel) getUserService().getCurrentUser(), orderCode);
        }
        catch (final ModelNotFoundException e)
        {
            throw new UnknownIdentifierException(String.format(ORDER_NOT_FOUND_FOR_USER, orderCode));
        }
        if (legacyOrderModel == null)
        {
            throw new UnknownIdentifierException(String.format(ORDER_NOT_FOUND_FOR_USER, orderCode));
        }

        return getLegacyOrderConverter().convert(legacyOrderModel);
    }


    protected <S, T> SearchPageData<T> convertPageData(final SearchPageData<S> source, final Converter<S, T> converter)
    {
        final SearchPageData<T> result = new SearchPageData<T>();
        result.setPagination(source.getPagination());
        result.setSorts(source.getSorts());
        result.setResults(Converters.convertAll(source.getResults(), converter));
        return result;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public LegacyOrderService getLegacyOrderService() {
        return legacyOrderService;
    }

    public void setLegacyOrderService(LegacyOrderService legacyOrderService) {
        this.legacyOrderService = legacyOrderService;
    }

    public Converter<LegacyOrderModel, LegacyOrderData> getLegacyOrderConverter() {
        return legacyOrderConverter;
    }

    public void setLegacyOrderConverter(Converter<LegacyOrderModel, LegacyOrderData> legacyOrderConverter) {
        this.legacyOrderConverter = legacyOrderConverter;
    }
}
