package edu.escuelaing.ARSW.ASE.app.Raiz;

import java.net.*;
import java.io.*;

public class server {


    /**
     * Clase Servidor que conecta al cliente
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String linea;
        while ((linea = in.readLine()) != null) {
            out.println(potencia(linea));
            if (Double.parseDouble(linea)==0.0) {
                System.out.println("Terminado");
                break;
            }
            else{
                System.out.println("Entrada:" + linea);
            }
    }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    /**
     * Metodo que recibe la linea y optiene la potencia del numero y mandarla nuevamente al cliente
     * @param linea ingreso del cliente
     * @return DOuble con el cuadrado del numero ingreo del cliente
     */
    private static Double potencia(String linea) {
        return Math.pow(Double.parseDouble(linea),2);
    }

}