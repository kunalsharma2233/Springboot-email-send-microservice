package com.emailsending.sendingemailapplication.service;

import com.emailsending.sendingemailapplication.entities.EmailDetails;

public interface EmailService {

    String sendSimpleMail(EmailDetails emailDetails);

    String sendMailWithAttachment(EmailDetails emailDetails);
}
