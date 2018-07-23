package com.produto.api.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produto.api.security.service.AuthProviderService;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthProviderService authProviderService;
	
	@GetMapping("/login")
	public void teste(Authentication authentication) {
		
		
		System.out.println(authentication.getCredentials());
	}

}
