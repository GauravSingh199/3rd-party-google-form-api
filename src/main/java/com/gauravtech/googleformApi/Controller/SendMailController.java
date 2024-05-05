package com.gauravtech.googleformApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gauravtech.googleformApi.FormDto.MailStructure;
import com.gauravtech.googleformApi.Service.MailService;

@RestController("system")
public class SendMailController {
    
    @Autowired
    private MailService mailService;

    @PostMapping("/sendForm")
    public String sendForm(@RequestBody MailStructure mailStructure) {
        String formType = mailStructure.getFormType();
        if ("contactForm".equals(formType)) {
            mailService.sendContactInfoForm(mailStructure);
            return "Contact Info Form sent successfully!";
        } else if ("eventForm".equals(formType)) {
            mailService.sendEventRegistrationForm(mailStructure);
            return "Event Registration Form sent successfully!";
        } else {
            return "Invalid form type!";
        }
    }
}

