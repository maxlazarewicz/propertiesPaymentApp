package pl.payment.main.domain.service.mailsender;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.payment.main.domain.client.mailsender.MailSenderClient;
import pl.payment.main.web.lead.MailLeadPayLoad;

import javax.transaction.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class MailSenderService {

    @Autowired
    MailSenderClient mailSenderClient;

    @Transactional
    public void newLead(MailLeadPayLoad mailLeadPayLoad) {
        mailSenderClient.newLead(mailLeadPayLoad);
    }

    @Transactional
    public void noPayment(MailLeadPayLoad mailLeadPayLoad) {
        mailSenderClient.noPayment(mailLeadPayLoad);
    }

    @Transactional
    public void paid(MailLeadPayLoad mailLeadPayLoad) {
        mailSenderClient.paid(mailLeadPayLoad);
    }
}
