package org.boynesoftware.requestgateway.controller;

import org.boynesoftware.configuration.model.User;
import org.boynesoftware.configuration.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	@ResponseBody
	public String createUser(@RequestBody User u, @AuthenticationPrincipal User user)
	{
		System.err.println(user);
		userService.createUser(u);
		return "sucess";
	}
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@AuthenticationPrincipal User user)
	{
		System.err.println(user);
		return new User();
	}
}
