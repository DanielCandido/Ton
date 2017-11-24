package project.ton.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailController
{

    public MailController() {
    	
	}
	
	public boolean sendMail(String to, String messageBody) {
		try
        {
            String server = "smtp.gmail.com";
            String port = "465";
            
            //email
            String user = "danielfcandido18@gmail.com";
            String password = "eusoumaiseu";

            Properties properties = new Properties();
            properties.put("mail.smtp.host", server);
            properties.put("mail.smtp.port", port);
            properties.put("mail.smtp.user", user);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.debug", "true");
            properties.put("mail.smtp.socketFactory.port", port);
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.socketFactory.fallback", "false");

            Session session = Session.getInstance(properties, new Autenticador(user, password));
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("TON divulga");
            message.setContent(messageBody, "text/html");
            
            Transport.send(message);
            
            return true;
        }
        catch (MessagingException tExcept)
        {
            System.out.println("Erro no processo de envio do email....");
            throw new RuntimeException(tExcept);
        }
	}
	
    private static class Autenticador extends Authenticator {
        private String mUsuario;
        private String mSenha;

        public Autenticador(String pUsuario, String pSenha)
        {
            super();
            mUsuario = pUsuario;
            mSenha = pSenha;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(mUsuario, mSenha);
        }
    }
}
