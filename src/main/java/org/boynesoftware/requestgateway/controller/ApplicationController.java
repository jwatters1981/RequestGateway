package org.boynesoftware.requestgateway.controller;

import org.boynesoftware.configuration.application.service.IApplicationService;
import org.boynesoftware.configuration.model.Application;
import org.boynesoftware.configuration.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("application")
public class ApplicationController
{

	@Autowired
	private IApplicationService applicationService;

	
	@ResponseBody
	public Application createApplication(@RequestBody Application application, @AuthenticationPrincipal User user)
	{
		return null;
		//applicationService.createApplication(application, organization);
	}
}
