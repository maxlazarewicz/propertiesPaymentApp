package pl.payment.main.domain.client.mailsender;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.payment.main.infrastructure.config.ClientConfig;
import pl.payment.main.web.lead.MailLeadPayLoad;

@FeignClient(
        value = "mailsender",
        url = "${client.mailsender.url}",
        configuration = ClientConfig.class)
public interface MailSenderClient {

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/mailsender/newlead",
            produces = "application/json")
    String newLead(MailLeadPayLoad mailLeadPayLoad);

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/mailsender/nopayment",
            produces = "application/json")
    String noPayment(MailLeadPayLoad mailLeadPayLoad);

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/mailsender/paid",
            produces = "application/json")
    String paid(MailLeadPayLoad mailLeadPayLoad);
}
