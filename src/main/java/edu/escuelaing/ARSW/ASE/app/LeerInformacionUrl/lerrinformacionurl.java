package edu.escuelaing.ARSW.ASE.app.LeerUrl.LeerInformacionUrl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class lerrinformacionurl {
    public static void main(String[] args) throws Exception {
        URL site = new URL("https://www.mercadolibre.com.co/");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(site.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}

