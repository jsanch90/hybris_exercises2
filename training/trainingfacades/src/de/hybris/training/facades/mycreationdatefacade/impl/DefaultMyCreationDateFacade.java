package de.hybris.training.facades.mycreationdatefacade.impl;

import de.hybris.platform.commercefacades.product.impl.DefaultProductVariantFacade;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.training.facades.mycreationdatefacade.MyCreationDateFacade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DefaultMyCreationDateFacade extends DefaultProductVariantFacade implements MyCreationDateFacade {

    @Override
    public void setCreationDate(String creationDate, String productCode) throws ParseException {
        Date newCreationDate = new SimpleDateFormat("yyyy-MM-dd").parse(creationDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(newCreationDate);
        cal.add(Calendar.HOUR, 1);
        Date oneHourBack = cal.getTime();
        ProductModel p = getProductService().getProductForCode(productCode);
        p.setMyCreationDate(oneHourBack);
        getModelService().save(p);

    }
}