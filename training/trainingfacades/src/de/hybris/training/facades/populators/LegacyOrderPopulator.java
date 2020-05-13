package de.hybris.training.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.training.core.model.LegacyOrderModel;
import de.hybris.training.facades.legacyorders.data.LegacyOrderData;
import org.junit.Assert;

public class LegacyOrderPopulator implements Populator<LegacyOrderModel, LegacyOrderData> {

    @Override
    public void populate(LegacyOrderModel legacyOrderModel, LegacyOrderData legacyOrderData) throws ConversionException {
        Assert.assertNotNull(legacyOrderModel);
        Assert.assertNotNull(legacyOrderData);
        legacyOrderData.setOrderNumber(legacyOrderModel.getOrderNumber());
        legacyOrderData.setOrderStatus(legacyOrderModel.getOrderStatus().getCode());
        legacyOrderData.setOrderTotal(legacyOrderModel.getOrderTotal());
        legacyOrderData.setPlaced(legacyOrderModel.getCreationtime()
        );
    }
}
