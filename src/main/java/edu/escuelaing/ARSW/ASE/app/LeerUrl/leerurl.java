package edu.escuelaing.ARSW.ASE.app.LeerUrl;

import java.net.MalformedURLException;
import java.net.URL;

public class leerurl {

    /**
     * Esta clase sirve para conocer los 8 metodos base para conocer de que manera esta formada una URL
     * @param args
     * @throws MalformedURLException
     */
    public static void main(String ... args) throws MalformedURLException{
        URL sitioweb = new URL("https://crmtransaccionales.ceet.co:8080/index.php?action=Login&module=Users#login");
        System.out.println(" El protocolo es :  "+ sitioweb.getProtocol());
        System.out.println(" El Host es :  "+ sitioweb.getHost());
        System.out.println(" El puerto es :  "+ sitioweb.getPort());
        System.out.println(" El Path es :  "+ sitioweb.getPath());
        System.out.println(" El File es :  "+ sitioweb.getFile());
        System.out.println(" El Ref es :  "+ sitioweb.getRef());
        System.out.println(" El Query es :  "+ sitioweb.getQuery());
        System.out.println(" El Authority es :  "+ sitioweb.getAuthority());
    }
}
