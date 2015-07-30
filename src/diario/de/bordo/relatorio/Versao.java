package diario.de.bordo.relatorio;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author joao.oliveira
 */
public class Versao {

//    final static ResourceBundle rb = ResourceBundle.getBundle("br.com.diariodebordo.res");
//
//    public static final String getRbTok(String propToken) {
//        String msg = "";
//        try {
//            msg = rb.getString(propToken);
//        } catch (MissingResourceException e) {
//            System.err.println("Token ".concat(propToken).concat(" not in Propertyfile!"));
//        }
//        return msg;
//    }

    public final String getVersion() {

        Properties prop = new Properties();
        InputStream input = null;

        try {
          //  System.out.println("\\br\\com\\diariodebordo\\res\\version.properties");
            input = this.getClass().getClassLoader().getResourceAsStream("version.properties");
            prop.load(input);
            return prop.getProperty("BUILD");

        } catch (IOException ex) {
           System.err.println(ex);
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

}
