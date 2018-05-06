package ru.itis.affection.services.impl;

import entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import ru.itis.affection.models.User;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(Object object) {

        User account = (User) object;

        MimeMessagePreparator preparator = getMessagePreparator(account);

        try {
            mailSender.send(preparator);
            System.out.println("Message Send...");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private MimeMessagePreparator getMessagePreparator(final User account) {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
//                String link = "http://localhost:4949/signup/accept?email=" + account.getEmail();
//                String text =
//                        String.format("Thanks for signing up ! You must follow this link to activate your account: \n <a href=\"%s\">%s</a>", link);
////                message.setFrom("support@ezyShop.com");
////                message.addTo(account.getEmail());
////                message.setSubject("Confirm account on EzY Shop");
////                message.setText(text);
//                mimeMessage.setFrom("zaynullin.emil@gmail.com");
//                mimeMessage.setRecipient(Message.RecipientType.TO,
//                        new InternetAddress(account.getEmail()));
//                mimeMessage.setText(text, "UTF-8");
//                mimeMessage.setSubject("Confirm account on EzY Shop");
            }
        };
        return preparator;
    }

}

