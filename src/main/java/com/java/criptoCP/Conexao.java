package com.java.criptoCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.PublicKey;
import java.util.Base64;

public class Conexao {

    public static String receber(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        /* 2048 / 8 = 256 bytes */
        byte infoBytes[] = new byte[256];
        int bytesLidos = in.read(infoBytes);

        if (bytesLidos > 0) {
            return Base64.getEncoder().encodeToString(infoBytes);
        } else {
            return "";
        }
    }

    public static PublicKey receberChave(Socket socket) throws Exception {
        InputStream in = socket.getInputStream();
        byte[] infoBytes = new byte[2048];
        int bytesLidos = in.read(infoBytes);

        if (bytesLidos > 0) {
            // Use apenas os bytes lidos
            byte[] chavePublicaBytes = new byte[bytesLidos];
            System.arraycopy(infoBytes, 0, chavePublicaBytes, 0, bytesLidos);
            return CriptografiaClienteServidor.bytesParaChave(chavePublicaBytes);
        } else {
            return null;
        }
    }

    public static void enviarChave(Socket socket, PublicKey chave) throws IOException {
        OutputStream out = socket.getOutputStream();
        out.write(chave.getEncoded());
        out.flush(); // Garantir que os dados sejam enviados
    }

    public static void enviar(Socket socket, String textoRequisicao) throws IOException {
        byte[] bytesRequisicao = Base64.getDecoder().decode(textoRequisicao);
        OutputStream out = socket.getOutputStream();
        out.write(bytesRequisicao);
        out.flush(); // Garantir que os dados sejam enviados
    }
}
