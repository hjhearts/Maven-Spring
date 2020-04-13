package com.spring.work02.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service("mailService")
public class MailService {
    @Autowired
    @Qualifier("mailSender")
    private JavaMailSender mailSender;
    @Autowired
    @Qualifier("preConfiguredMessage")
    private SimpleMailMessage preConfiguredMessage;
    @Async
    public void sendMail(String to, String subject, String body){
        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            messageHelper.setCc("gkska1029@naver.com");
            messageHelper.setFrom("hjhearts21@gmail.com");
            messageHelper.setSubject(subject);
            messageHelper.setTo(to);
            messageHelper.setText(body);
            mailSender.send(message);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Async
    public void sendConfiguredMail(String text){
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(text);
        mailSender.send(mailMessage);
    }
    @Async
    public void sendApacheMail() throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("hjhearts21@gmail.com", "wntjd4725%"));
        email.setSSLOnConnect(true);
        email.setFrom("user@gmail.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("gkska1029@naver.com");
        email.send();
    }
}
