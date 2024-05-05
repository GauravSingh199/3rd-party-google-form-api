package com.gauravtech.googleformApi.Service;

import com.gauravtech.googleformApi.FormDto.MailStructure;

public interface MailService {

	

	public void sendContactInfoForm(MailStructure mailStructure);

	public void sendEventRegistrationForm(MailStructure mailStructure);
}
