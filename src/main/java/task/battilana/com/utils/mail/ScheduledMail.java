package task.battilana.com.utils.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledMail {

    private final JavaMailSender javaMailSender;
    private final Logger logger = LoggerFactory.getLogger(ScheduledMail.class);

    public ScheduledMail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void enviarMail() {
        try{
            MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setFrom("gestorarticulos@battilana.biz");
            helper.setTo("fhurtado@battilana.biz");
            helper.setSubject("Test");
            helper.setText("HOLAAAAAAAAAAAAAAAAAAAAAAAAAA");


            this.javaMailSender.send(mimeMessage);

            logger.info("Correo enviado: {}", new Date());


        }catch (MessagingException ex){
            System.out.println("Error: " + ex);
        }
    }
}
