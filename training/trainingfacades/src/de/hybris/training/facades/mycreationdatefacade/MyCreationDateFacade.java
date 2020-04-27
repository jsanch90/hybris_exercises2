package de.hybris.training.facades.mycreationdatefacade;

import java.text.ParseException;

public interface MyCreationDateFacade {
    void setCreationDate(String creationDate, String productCode) throws ParseException;
}