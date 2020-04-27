package de.hybris.training.core.attributehandlers;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

public class ProductPastDaysAttributeHandler implements DynamicAttributeHandler<Integer, ProductModel> {

    @Override
    public Integer get(ProductModel model) {
        if(Optional.ofNullable(model.getMyCreationDate()).isPresent()){
            final LocalDateTime creationDate = model.getMyCreationDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            final LocalDateTime currentDate = LocalDateTime.now();
            final Long pastDays = Duration.between(creationDate, currentDate).toDays();
            return pastDays.intValue();
        }
        return Integer.valueOf(0);
    }

    @Override
    public void set(ProductModel model, Integer integer) {
        throw new UnsupportedOperationException("Write is not a valid operation for this dynamic attribute");
    }
}
