package eu.sig.training.ch05.buildandsendmail;

public class BuildAndSendMail {
    // tag::buildAndSendMail[]
    public void buildAndSendMail(MailMan m, MailAddress mailAddress, MailContent mailContent,MailFont font) {
        // Format the email address
        
        // Format the message given the content type and raw message
        MailMessage mMessage = formatMessage(font,mailContent.getMailMessage());
        // Send message
        m.send(mailAddress.getMailAddress(), mailContent.subject, mMessage);
    }
    // end::buildAndSendMail[]

    @SuppressWarnings("unused")
    private MailMessage formatMessage(MailFont font, String string) {
        return null;
    }

    private class MailMan {

        @SuppressWarnings("unused")
        public void send(String mId, String subject, MailMessage mMessage) {}

    }

    private class MailFont {

    }

    private class MailMessage {

    }

}