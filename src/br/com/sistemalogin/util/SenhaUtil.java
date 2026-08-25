package br.com.sistemalogin.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SenhaUtil {

    public static String gerarHash(String senha) {

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hash = md.digest(
                senha.getBytes(StandardCharsets.UTF_8)
            );

            StringBuilder resultado = new StringBuilder();

            for (byte b : hash) {

                resultado.append(String.format("%02x", b));
            }

            return resultado.toString();

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException(e);
        }
    }
}
