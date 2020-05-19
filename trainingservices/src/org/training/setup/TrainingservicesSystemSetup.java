/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.training.setup;

import static org.training.constants.TrainingservicesConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import org.training.constants.TrainingservicesConstants;
import org.training.service.TrainingservicesService;


@SystemSetup(extension = TrainingservicesConstants.EXTENSIONNAME)
public class TrainingservicesSystemSetup
{
	private final TrainingservicesService trainingservicesService;

	public TrainingservicesSystemSetup(final TrainingservicesService trainingservicesService)
	{
		this.trainingservicesService = trainingservicesService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		trainingservicesService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return TrainingservicesSystemSetup.class.getResourceAsStream("/trainingservices/sap-hybris-platform.png");
	}
}
