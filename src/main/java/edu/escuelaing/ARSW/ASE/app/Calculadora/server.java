package edu.escuelaing.ARSW.ASE.app.Calculadora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class server {



    /**
     * Clase Servidor que conecta al cliente y realiza calculo de sin, cos , tan al numero ingresado
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Double numero;
        Double sol = 0.0;
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
        String liena;
        int bandera = 3;
        while ((liena = in.readLine()) != null) {
            System.out.println("Mensaje:" + liena);

            if( liena.equals("fun:sin")){
                bandera=2;
            }
            else if( liena.equals("fun:cos")){
                bandera=3;
            }
            else  if( liena.equals("fun:tan")){
                bandera=4;
            }
            else{
                numero=Double.parseDouble(liena);

                if(bandera==2){
                    sol=Math.sin(numero);
                }
                else if(bandera==3){
                    sol=Math.cos(numero);
                }
                else if(bandera==4){
                    sol=Math.tan(numero);
                }
            }
            out.println("El resultado es:"+sol);
            if (liena.equals("")) {
                break;
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}