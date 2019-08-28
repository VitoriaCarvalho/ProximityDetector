package proximitydetectorserver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author vitoria
 */
public class Server {
    
    public static Socket cliente;
    public static boolean flag;
    public static Audio audio;
    public static String conexoes;
    
    public static void main(String[] args) throws IOException {
        flag = false; // alterar isso no botão de alarme
        conexoes = "";
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Porta 12345 aberta!");
            while (true) {
                System.out.println(flag);
                cliente = servidor.accept();
                System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
                if (flag) {
                    Runnable tratamentoClass = new TratamentoClass(cliente);
                    Thread t = new Thread(tratamentoClass);
                } else {
                    Runnable tratamentoClass = new TratamentoClass(cliente);
                    Thread t = new Thread(tratamentoClass);
                    t.start();
                    flag = true;
                }
            }
            
        } catch (IOException e) {
            //TODO: handle exception
        } finally {
            cliente.close();
        }
        
        System.out.println("FEZ A CONEXAO");
    }
    
}
