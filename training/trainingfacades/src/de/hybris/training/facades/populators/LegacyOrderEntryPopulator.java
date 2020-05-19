package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.training.core.model.LegacyOrderEntryModel;
import de.hybris.training.facades.legacyorders.data.LegacyOrderEntryData;

public class LegacyOrderEntryPopulator implements Populator<LegacyOrderEntryModel, LegacyOrderEntryData> {

    private Converter<ProductModel, ProductData> productConverter;

    @Override
    public void populate(LegacyOrderEntryModel legacyOrderEntryModel, LegacyOrderEntryData legacyOrderEntryData) throws ConversionException {
        legacyOrderEntryData.setBasePrice(legacyOrderEntryModel.getBasePrice());
        legacyOrderEntryData.setProduct(getProductConverter().convert(legacyOrderEntryModel.getProduct()));
        legacyOrderEntryData.setQuantity(legacyOrderEntryModel.getQuantity());

    }

    public Converter<ProductModel, ProductData> getProductConverter() {
        return productConverter;
    }

    public void setProductConverter(Converter<ProductModel, ProductData> productConverter) {
        this.productConverter = productConverter;
    }
}
