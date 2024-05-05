package com.gauravtech.googleformApi.ServiceImpl.copy;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;

import com.gauravtech.googleformApi.FormDto.CreateFormDto;
import com.gauravtech.googleformApi.Service.FormService;
import com.gauravtech.googleformApi.Util.GoogleApiUtil;

public class FormServiceImpl implements FormService {
	
	@Autowired(required=true)
	private GoogleApiUtil googleApiUtil;

	@Override
	public String createForm(CreateFormDto createDto) throws IOException, GeneralSecurityException {
		googleApiUtil.createForm(createDto);
		return null;
	}

}
