package com.java.criptoCP;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class CriptografiaClienteServidor {

    // Método para gerar um par de chaves (pública e privada)
    public static KeyPair gerarChavesPublicoPrivada() throws NoSuchAlgorithmException {
        KeyPairGenerator geradorChave = KeyPairGenerator.getInstance("RSA");
        geradorChave.initialize(2048); // Tamanho da chave em bits
        return geradorChave.generateKeyPair(); // Retorna o par de chaves gerado
    }

    // Método para cifrar uma mensagem usando a chave pública
    public static String cifrar(String mensagem, PublicKey publicKey) throws Exception {
        byte[] messageToBytes = mensagem.getBytes("UTF-8"); // Converter mensagem para bytes
        Cipher cifrador = Cipher.getInstance("RSA/ECB/PKCS1Padding"); // Criar objeto de cifra

        // Inicializar o cifrador em modo de encriptação
        cifrador.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytesCripto = cifrador.doFinal(messageToBytes); // Cifrar a mensagem

        return Base64.getEncoder().encodeToString(bytesCripto); // Retornar a mensagem cifrada em Base64
    }

    // Método para decifrar uma mensagem usando a chave privada
    public static String decifrar(String mensagem, PrivateKey privateKey) throws Exception {
        byte[] bytesCifrados = Base64.getDecoder().decode(mensagem); // Decodificar a mensagem cifrada
        Cipher cifrador = Cipher.getInstance("RSA/ECB/PKCS1Padding"); // Criar objeto de cifra

        // Inicializar o cifrador em modo de decriptação
        cifrador.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] mensagemDecifrada = cifrador.doFinal(bytesCifrados); // Decifrar a mensagem

        return new String(mensagemDecifrada, "UTF-8"); // Retornar a mensagem decifrada como string
    }

    // Método para converter bytes da chave pública em um objeto PublicKey
    public static PublicKey bytesParaChave(byte[] bytesChave) throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytesChave); // Criar especificação da chave
        KeyFactory keyFactory = KeyFactory.getInstance("RSA"); // Criar fábrica de chaves
        return keyFactory.generatePublic(keySpec); // Retornar a chave pública gerada
    }
}
