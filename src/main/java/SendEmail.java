import org.apache.commons.mail.SimpleEmail;
/**
 *
 * @author thaina.matos
 */
public class SendEmail {
    public String emailUser;
    GeneratePassword password = new GeneratePassword();

    String temporaryPassword = password.getPassword();

    public void SendEmail(String emailUser){
        String meuEmail = "heath.care.usjt@gmail.com";
        String minhaSenha = "biknmvupglyvamrw";
        
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthentication(meuEmail,minhaSenha);
        email.setSSLOnConnect(true);

        try {
            email.setFrom(meuEmail);
            email.setSubject("Sua senha da aplicação desktop Health Care foi alterada");
            email.setMsg(" Esqueceu sua senha? Está tudo bem. " + 
                    "\n Alteramos sua senha para: " + temporaryPassword + 
                    "\n Entre com ela, mas logo em seguida redefina sua senha na nossa aplicação.");
            email.addTo(emailUser);

            email.send();
            System.out.println("Email enviado.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public String getTemporaryPassword() {
        return temporaryPassword;
    }
}
