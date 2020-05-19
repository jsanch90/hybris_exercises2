package de.hybris.training.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.training.core.jalo.LegacyOrder;
import de.hybris.training.core.jalo.LegacyOrderEntry;
import de.hybris.training.core.model.LegacyOrderEntryModel;
import de.hybris.training.core.model.LegacyOrderModel;
import de.hybris.training.facades.legacyorders.data.LegacyOrderData;
import de.hybris.training.facades.legacyorders.data.LegacyOrderEntryData;
import org.junit.Assert;

import java.util.List;

public class LegacyOrderPopulator implements Populator<LegacyOrderModel, LegacyOrderData> {

    private Converter<LegacyOrderEntryModel, LegacyOrderEntryData> legacyOrderEntryConverter;

    @Override
    public void populate(LegacyOrderModel legacyOrderModel, LegacyOrderData legacyOrderData) throws ConversionException {
        Assert.assertNotNull(legacyOrderModel);
        Assert.assertNotNull(legacyOrderData);
        legacyOrderData.setOrderNumber(legacyOrderModel.getOrderNumber());
        legacyOrderData.setOrderStatus(legacyOrderModel.getOrderStatus().getCode());
        legacyOrderData.setOrderTotal(computeLegacyOrderTotal(getLegacyOrderEntries(legacyOrderModel)));
        legacyOrderData.setPlaced(legacyOrderModel.getCreationtime());
        legacyOrderData.setOrderEntries(getLegacyOrderEntries(legacyOrderModel));
    }

    protected Double computeLegacyOrderTotal(final List<LegacyOrderEntryData> entries){
        return entries.stream().map(entry -> entry.getBasePrice()*entry.getQuantity()).reduce((a,b) -> a+b).orElse(Double.valueOf(0));
    }

    protected List<LegacyOrderEntryData> getLegacyOrderEntries(final LegacyOrderModel legacyOrder){
        return getLegacyOrderEntryConverter().convertAll(legacyOrder.getLegacyOrderEntry());
    }

    public Converter<LegacyOrderEntryModel, LegacyOrderEntryData> getLegacyOrderEntryConverter() {
        return legacyOrderEntryConverter;
    }

    public void setLegacyOrderEntryConverter(Converter<LegacyOrderEntryModel, LegacyOrderEntryData> legacyOrderEntryConverter) {
        this.legacyOrderEntryConverter = legacyOrderEntryConverter;
    }
}
