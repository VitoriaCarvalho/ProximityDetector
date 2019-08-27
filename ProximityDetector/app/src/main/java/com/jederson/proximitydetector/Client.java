package com.jederson.proximitydetector;

import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Client extends AsyncTask<Void, Void, Void> {

    String host= "192.168.43.68";
    int port = 12345;
    String email, longitude, latitude;

    public Client (String email, String longitude, String latitude) {
        this.email = email;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        Socket socket = null;

        try {
            Socket cliente = new Socket(host, port);
            Log.d("Mensagem", "Conectado com sucesso!");
            PrintStream mensagem = new PrintStream(cliente.getOutputStream());
            mensagem.println(String.format("%s:%s:%s", email, longitude, latitude));
        } catch (Exception e) {
            Log.d("Mensagem", "Conexão falhou!!");
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }

}