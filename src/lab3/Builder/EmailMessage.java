package lab3.Builder;

import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;
import java.io.Console;

public class EmailMessage {

    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc;

    private EmailMessage(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.subject = builder.subject;
        this.content = builder.content;
        this.mimeType = builder.mimeType;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
    }

    public String getFrom() {
        return from;
    }

    public LinkedList<String> getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getMimeType() {
        return mimeType;
    }

    public LinkedList<String> getCc() {
        return cc;
    }

    public LinkedList<String> getBcc() {
        return bcc;
    }

    static public class Builder{
        private String from;
        private LinkedList<String> to;
        private String subject;
        private String content;
        private String mimeType;
        private LinkedList<String> cc;
        private LinkedList<String> bcc;


        public boolean CheckAdress(String email){
            boolean result = true;
            try {
                InternetAddress emailAddr = new InternetAddress(email);
                emailAddr.validate();
            } catch (AddressException ex) {
                result = false;
            }
            return result;
        }

        public Builder addFrom(String from){
            if(CheckAdress(from)) {
                this.from = from;
                return this;
            }
            else{
                throw new IllegalArgumentException("Niewłaściwy adres nadawcy!");
            }

        }

        public Builder addTo(LinkedList<String> to){
            for(int i=0; i<to.size(); i++){
                if(!CheckAdress(to.get(i))){
                    throw new IllegalArgumentException("Niewłaściwy adres odbiorcy numer "+i);
                }
            }
            this.to=to;
            return this;
        }

        public Builder addSubject (String subject){
            this.subject=subject;
            return this;
        }

        public Builder addContent(String content){
            this.content=content;
            return this;
        }

        public Builder addMimeType(String mimeType){
            this.mimeType=mimeType;
            return this;
        }

        public Builder addCc(LinkedList<String> cc){
            this.cc=cc;
            return this;
        }

        public Builder addBcc(LinkedList<String> bcc){
            this.bcc=bcc;
            return this;
        }

        public EmailMessage build(){
            return new EmailMessage(this);
        }
    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    public void send() {
        final String username = this.from;
        final String password;
        System.out.println("Podaj hasło do konta: ");
/*
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        char passwordArray[] = console.readPassword("Wprowadź hasło do konta: ");
        password=new String(passwordArray);
*/
        Scanner odczyt=new Scanner(System.in);
        password=odczyt.nextLine();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(this.to.get(0)));
            message.setSubject(this.subject);
            message.setText(this.content);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

