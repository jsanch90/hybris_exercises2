package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class MyCreationDatePopulator implements Populator<ProductModel, ProductData> {

    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        Assert.assertNotNull(productModel);
        Assert.assertNotNull(productData);
        final SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d yyyy");
        if (Optional.ofNullable(productModel.getMyCreationDate()).isPresent()){
            final String formattedMyCreationDate = formatter.format(productModel.getMyCreationDate());
            productData.setFormattedMyCreationDate(formattedMyCreationDate);
            productData.setMyCreationDate(productModel.getMyCreationDate());
        }else{
            final String formattedMyCreationDate = formatter.format(new Date());
            productData.setFormattedMyCreationDate(formattedMyCreationDate);
            productData.setMyCreationDate(new Date());
        }
        productData.setPastDays(productModel.getPastDays().toString());
    }
}
