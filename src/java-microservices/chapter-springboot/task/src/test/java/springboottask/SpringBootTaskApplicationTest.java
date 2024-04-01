/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springboottask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
public class SpringBootTaskApplicationTest {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void testSendSimpleMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("邮件发送测试");
        mailMessage.setText("正在测试spring-boot-starter-mail");

        mailMessage.setTo("szhxiao@yeah.net");
        mailMessage.setFrom("543094982@qq.com");

        mailSender.send(mailMessage);
    }

    @Test
    public void testSendMimeMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMessage, true);

        // 邮件设置
        mimeHelper.setSubject("复杂邮件测试");
        mimeHelper.setText("<b style='color:red'>复杂邮件测试</b>", true);

        mimeHelper.setTo("szhxiao@yeah.net");
        mimeHelper.setFrom("543094982@qq.com");

        // 上传附件
        mimeHelper.addAttachment("SpringBootTaskApplicationTest.java", new File("/home/szhxiao/Codespaces/java-zen-studio/src/java-microservices/chapter-springboot/task/src/test/java/springboottask/SpringBootTaskApplicationTest.java"));

        mailSender.send(mimeMessage);
    }
}
