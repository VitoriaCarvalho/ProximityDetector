/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proximitydetectorserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static proximitydetectorserver.Server.audio;
import static proximitydetectorserver.Server.conexoes;

/**
 *
 * @author vitoria
 */
public class TratamentoClass implements Runnable {
 
    private final Socket cliente;
    private InterfaceServer2 interfaceServer;

    public TratamentoClass(Socket cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void run() {
        try {
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
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println(e.getMessage());
        }
    }
    
}