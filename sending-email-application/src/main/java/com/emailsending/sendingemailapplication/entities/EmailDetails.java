package com.emailsending.sendingemailapplication.entities;

public class EmailDetails {

    private String recipient;
    private String body;
    private String subject;
    private String attachment;

    public EmailDetails() {
        super();
    }

    public EmailDetails(String recipient, String body, String subject, String attachment) {
        super();
        this.recipient = recipient;
        this.body = body;
        this.subject = subject;
        this.attachment = attachment;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getAttachment() {
        return attachment;
    }

    @Override
    public String toString() {
        return "EmailDetails{" +
                "recipient='" + recipient + '\'' +
                ", body='" + body + '\'' +
                ", subject='" + subject + '\'' +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
