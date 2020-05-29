/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved
 */
package org.training.widgets;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Label;

import com.hybris.cockpitng.util.DefaultWidgetController;

import org.training.services.CustombackofficeService;


public class CustombackofficeController extends DefaultWidgetController
{
	private static final long serialVersionUID = 1L;
	private Label label;

	@WireVariable
	private transient CustombackofficeService custombackofficeService;

	@Override
	public void initialize(final Component comp)
	{
		super.initialize(comp);
		label.setValue(custombackofficeService.getHello() + " CustombackofficeController");
	}
}
