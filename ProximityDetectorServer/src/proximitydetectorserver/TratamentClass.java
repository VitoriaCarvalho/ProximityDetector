package proximitydetectorserver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author vitoria
 */
public class TratamentClass {
    
    public static Socket cliente;
    public static boolean flag;
    public static Audio audio;
    public static String conexoes;
    
    public static void main(String[] args) throws IOException {
        flag = false; // alterar isso no botão de alarme
        conexoes = "";
        InterfaceServer2 interfaceServer;
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Porta 12345 aberta!");
            while (true) {
                //System.out.println(flag);
                if(flag) continue;
                cliente = servidor.accept();
                flag = true;
                System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
                //Thread t = new Thread(tratamentoClass);
                //t.start();
                InputStream is = cliente.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String dados = br.readLine();
                System.out.println(dados);
                conexoes += dados;
                String longitude = dados.split(":")[1];
                String latitude = dados.split(":")[2];
                interfaceServer = new InterfaceServer2(longitude, latitude);
                interfaceServer.setVisible(true);
                audio = new Audio();
                audio.play();
            }
            
        } catch (Exception e) {
            //TODO: handle exception
        } finally {
            cliente.close();
        }
        
        System.out.println("FEZ A CONEXAO");
    }
    
}
