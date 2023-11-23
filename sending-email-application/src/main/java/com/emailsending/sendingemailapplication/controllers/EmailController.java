package com.emailsending.sendingemailapplication.controllers;

import com.emailsending.sendingemailapplication.entities.EmailDetails;
import com.emailsending.sendingemailapplication.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(value = "/sendMail")
    public String sendSimpleMail(@RequestBody EmailDetails emailDetails) {
        String status = emailService.sendSimpleMail(emailDetails);
        return status;
    }

    @PostMapping(value = "/sendMailAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails emailDetails) {
        String status = emailService.sendMailWithAttachment(emailDetails);
        return status;
    }
}
