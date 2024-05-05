package com.gauravtech.googleformApi.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.gauravtech.googleformApi.FormDto.CreateFormDto;

public interface FormService {

	String createForm(CreateFormDto createDto) throws IOException, GeneralSecurityException;

	

}
