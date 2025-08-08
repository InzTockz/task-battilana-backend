package task.battilana.com.utils.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import task.battilana.com.entity.TareasEntity;
import task.battilana.com.entity.UsuariosEntity;
import task.battilana.com.repository.TareasRepository;
import task.battilana.com.repository.UsuarioRepository;

import java.util.Date;
import java.util.List;

@Component
public class ScheduledMail {

    private final JavaMailSender javaMailSender;
    private final Logger logger = LoggerFactory.getLogger(ScheduledMail.class);
    private final TareasRepository tareasRepository;
    private final UsuarioRepository usuarioRepository;
    private final TemplateEngine templateEngine;

    public ScheduledMail(JavaMailSender javaMailSender, TareasRepository tareasRepository, UsuarioRepository usuarioRepository, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.tareasRepository = tareasRepository;
        this.usuarioRepository = usuarioRepository;
        this.templateEngine = templateEngine;
    }

    //@Scheduled(cron = "0 */5 * * * *")
    public void enviarMail() {
        try{

            List<UsuariosEntity> usuariosEntity = this.usuarioRepository.findAll();

            if(!usuariosEntity.isEmpty()){
                for(UsuariosEntity usuarios : usuariosEntity){
                    List<TareasEntity> tareasEntity = this.tareasRepository.listadoTareasPorUsuario(usuarios.getIdUsuarios());

                    if(!tareasEntity.isEmpty()){
                        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
                        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

                        helper.setFrom("gestorarticulos@battilana.biz");
                        helper.setTo("fhurtado@battilana.biz");
                        helper.setSubject("Test");

                        Context context = new Context();
                        context.setVariable("listaTareas", tareasEntity);
                        String html = this.templateEngine.process("task-recordatory", context);

                        helper.setText(html);


                        this.javaMailSender.send(mimeMessage);

                        logger.info("Correo enviado: {}", new Date());
                    }
                }
            }

        }catch (MessagingException ex){
            System.out.println("Error: " + ex);
        }
    }
}
