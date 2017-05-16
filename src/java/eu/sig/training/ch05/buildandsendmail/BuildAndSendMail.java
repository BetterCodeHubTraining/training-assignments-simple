package eu.sig.training.ch05.buildandsendmail;

public class BuildAndSendMail {
    // tag::buildAndSendMail[]
    public void buildAndSendMail(MailMan m, Mail mail) {
        // Format the email address
        
        // Format the message given the content type and raw message
        
        // Send message
        m.send(mail.mailAddress, mail.mailContent.subject, mail.formatMessage());
    }
    // end::buildAndSendMail[]

    @SuppressWarnings("unused")
    

    private class MailMan {

        @SuppressWarnings("unused")
        public void send(MailAddress mailAddress, String subject, String message) {}

    }

    

    private class MailMessage {

    }

}