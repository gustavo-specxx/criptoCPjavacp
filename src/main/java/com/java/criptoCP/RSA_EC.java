package com.java.criptoCP;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class RSA_EC {

    public static void main(String[] args) {
        // Mensagem original
        String msg = "agencia 5454 cc 6566-2 senha 1876563";
        String msgCifrada;
        String msgDecifrada;

        // Números primos p e q
        BigInteger p = new BigInteger("61");
        BigInteger q = new BigInteger("53");

        // Cálculo de n
        BigInteger n = p.multiply(q);
        // Escolha do expoente público
        BigInteger e = new BigInteger("65537");

        // Cálculo de m (φ(n))
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        // Cálculo do expoente privado d
        BigInteger d = e.modInverse(m);

        // Impressão das chaves
        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("n: " + n);
        System.out.println("e: " + e);
        System.out.println("d: " + d);

        // Cifrar a mensagem
        byte[] msgBytes = msg.getBytes(StandardCharsets.US_ASCII);
        StringBuilder cifradaStringBuilder = new StringBuilder();

        for (byte b : msgBytes) {
            BigInteger msgBigInt = new BigInteger(1, new byte[] { b }); // A representação positiva do byte
            BigInteger cifrada = msgBigInt.modPow(e, n); // Cifrar a mensagem
            cifradaStringBuilder.append(cifrada).append(" "); // Adicionar à string
        }
        msgCifrada = cifradaStringBuilder.toString().trim();

        System.out.println("Mensagem cifrada: " + msgCifrada);

        // Decifrar a mensagem
        String[] cifradaParts = msgCifrada.split(" ");
        StringBuilder decifradaStringBuilder = new StringBuilder();

        for (String part : cifradaParts) {
            BigInteger cifradaBigInt = new BigInteger(part);
            BigInteger decifrada = cifradaBigInt.modPow(d, n); // Decifrar a mensagem
            decifradaStringBuilder.append((char) decifrada.byteValueExact()); // Converter para char
        }
        msgDecifrada = decifradaStringBuilder.toString();

        System.out.println("Mensagem decifrada: " + msgDecifrada);
    }
}
