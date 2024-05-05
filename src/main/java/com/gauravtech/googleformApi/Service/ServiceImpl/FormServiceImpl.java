package com.gauravtech.googleformApi.Service.ServiceImpl;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gauravtech.googleformApi.FormDto.CreateFormDto;
import com.gauravtech.googleformApi.Service.FormService;
import com.gauravtech.googleformApi.Util.GoogleApiUtil;

@Service
public class FormServiceImpl implements FormService {
	
	@Autowired(required=true)
	private GoogleApiUtil googleApiUtil;

	@Override
	public String createForm(CreateFormDto createDto) throws IOException, GeneralSecurityException {
		String formid = googleApiUtil.createForm(createDto);
		return formid;
	}

}
