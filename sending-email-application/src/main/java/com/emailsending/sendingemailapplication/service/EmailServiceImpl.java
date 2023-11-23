package com.emailsending.sendingemailapplication.service;

import com.emailsending.sendingemailapplication.entities.EmailDetails;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailServiceImpl implements EmailService{

    @Value("${spring.mail.username}")
    private String sender;

    private JavaMailSender javaMailSender;

    EmailServiceImpl(JavaMailSender javaMailSender) {
        super();
        this.javaMailSender = javaMailSender;
    }

    public String sendSimpleMail(EmailDetails emailDetails) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(emailDetails.getRecipient());
            simpleMailMessage.setText(emailDetails.getBody());
            simpleMailMessage.setSubject(emailDetails.getSubject());
            javaMailSender.send(simpleMailMessage);
            return "Mail sent successfully!";
        } catch (Exception e) {
            return "Mail not send! Something went wrong";
        }
    }

    public String sendMailWithAttachment(EmailDetails emailDetails) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setText(emailDetails.getBody());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
            FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));
            mimeMessageHelper.addAttachment(file.getFilename(), file);
            javaMailSender.send(mimeMessage);
            return "Mail sent successfully!";
        } catch (MessagingException e) {
            return "Mail not send! Something went wrong";
        }
    }
}
