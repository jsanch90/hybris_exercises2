/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.training.service;

public interface TrainingservicesService
{
	String getHybrisLogoUrl(String logoCode);

	void createLogo(String logoCode);
}
