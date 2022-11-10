package pl.payment.main.domain.mail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Slf4j
@Service
@AllArgsConstructor
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendContactMail() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo("mxlazarewicz@gmail.com");
            helper.setSubject("Witaj");
            helper.setText("Random");

            javaMailSender.send(message);


        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
