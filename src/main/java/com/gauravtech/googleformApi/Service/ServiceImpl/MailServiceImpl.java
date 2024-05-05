package com.gauravtech.googleformApi.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gauravtech.googleformApi.FormDto.MailStructure;
import com.gauravtech.googleformApi.Service.MailService;

@Service
public class MailServiceImpl implements MailService {
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Value("${spring.mail.username}")
    private String fromMail;

    private final String contactForm = "https://forms.gle/dEVP1GYaacGRussh9";
    private final String eventForm = "https://forms.gle/5RkdwCM2y9rzxCtE7";

    @Override
    public void sendContactInfoForm(MailStructure mailStructure) {
        sendMail(mailStructure, contactForm);
    }

    @Override
    public void sendEventRegistrationForm(MailStructure mailStructure) {
        sendMail(mailStructure, eventForm);
    }

    private void sendMail(MailStructure mailStructure, String formUrl) {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setFrom(fromMail);
        simpleMessage.setTo(mailStructure.getToEmail());
        simpleMessage.setSubject(mailStructure.getSubject());
        simpleMessage.setText(mailStructure.getBody() + "\n" + formUrl);
        
        mailSender.send(simpleMessage);
    }
}
