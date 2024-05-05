package com.gauravtech.googleformApi.Controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gauravtech.googleformApi.FormDto.CreateFormDto;
import com.gauravtech.googleformApi.Service.FormService;

@RestController
public class DashbordController {
	
	@Autowired(required=true)
	private FormService formService;

	@GetMapping("/check")
	public String check() {
		return "checking API";
	}
	
	@GetMapping()
	public String readDataFrom() {
		return "checking API";
	}
	
	@PostMapping("/createForm")
	public String createGoogleForm(@RequestBody CreateFormDto createDto) throws IOException, GeneralSecurityException {
		String formId=formService.createForm(createDto);
		return formId ;
	}
}
