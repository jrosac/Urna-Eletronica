package poo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public static String generateHash(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        try (DigestInputStream inputStream = new DigestInputStream(new FileInputStream(file), digest)) {
            // Lê o arquivo para calcular a hash
            byte[] buffer = new byte[8192];
            while (inputStream.read(buffer) != -1) {}
        }
        byte[] hashBytes = digest.digest();
        StringBuilder hexString = new StringBuilder();

        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
    public static String generateHash(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(text.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static void main(String[] args) {
        try {
            File file = new File("caminho/para/o/arquivo.txt");
            String hash = generateHash(file);
            System.out.println("Hash SHA256 do arquivo: " + hash);
        } catch (NoSuchAlgorithmException | IOException e) {
            System.err.println("Erro ao gerar hash: " + e.getMessage());
        }
    }
}
