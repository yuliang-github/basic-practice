package com.yl.encrypt;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author Alex
 * @since 2019/1/11 22:14
 */
public class RSAEncrypt {


    public static void main(String[] args) throws Exception{

        KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance("RSA");

        pairGenerator.initialize(512);

        KeyPair keyPair = pairGenerator.generateKeyPair();

        System.err.println("公钥:" + Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));

        System.err.println("私钥:" + Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
    }

    public static String publicKeyEncryptToHex(String src,String publicKey) throws Exception{
        Cipher rsa = Cipher.getInstance("RSA");
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
        PublicKey key = keyFactory.generatePublic(x509EncodedKeySpec);
        rsa.init(Cipher.ENCRYPT_MODE, key);
        return Hex.encodeHexString(rsa.doFinal(src.getBytes()));
    }

    public static String publicKeyDecypt(String hexStr,String publicKey) throws Exception{
        Cipher rsa = Cipher.getInstance("RSA");
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
        PublicKey key = keyFactory.generatePublic(x509EncodedKeySpec);
        rsa.init(Cipher.DECRYPT_MODE, key);
        return new String(rsa.doFinal(Hex.decodeHex(hexStr)));
    }

    public static String privateKeyDecrypt(String hexStr,String privateKey) throws Exception{
        Cipher rsa = Cipher.getInstance("RSA");
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        rsa.init(Cipher.DECRYPT_MODE, key);
        return new String(rsa.doFinal(Hex.decodeHex(hexStr)));
    }

    public static String privateKeyEncryptToHex(String src,String privateKey) throws Exception{
        Cipher rsa = Cipher.getInstance("RSA");
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        PrivateKey key = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        rsa.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = rsa.doFinal(src.getBytes());
        return Hex.encodeHexString(bytes);
    }

    static String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKkZF1Hi4yMqugaZo/dqWI0P2sUmVs0HugDavWWTlUKDCoCaaCZmMmhb+4zDQB+D2ojVkY8AU26J5OZJbvI6MnECAwEAAQ==";

    static String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAqRkXUeLjIyq6Bpmj92pYjQ/axSZWzQe6ANq9ZZOVQoMKgJpoJmYyaFv7jMNAH4PaiNWRjwBTbonk5klu8joycQIDAQABAkEAlnlkfhLnyvCHj74C4fV5jTWRmSTP0y3QAFimd5CIHyFlzoqnwMz3M+wlVDDFTOQXlMsFF2QvM3NudGIvwHxdEQIhAOx5QY0L8Wg8PRTN0epM09SBgfHWMnkFzMOmG3WBig79AiEAtw+aHHIXqK4H5yKUHC8Z5luYtW+JBnX75d0rED3Q3YUCIEJSu/TgTaPriUIle+OYCq2GaTi3184jt0uEch0h6OPNAiEAtVRCDo1BPDfu4hfRaD2LxS/UC1zI+VpjQ2UZ5AOnYdUCIAMok9njwxdMkuLwRk2jK3L6zOt3q5Jt8qM4Zj07sHh6";

    @Test
    public void demo_01() throws Exception{

        String src = "关关雎鸠";

        String publicKeyEncrypt = publicKeyEncryptToHex(src, publicKey);
        System.err.println(publicKeyEncrypt);

        String privateKeyDecrypt = privateKeyDecrypt(publicKeyEncrypt, privateKey);
        System.err.println(privateKeyDecrypt);


        String privateKeyEncrypt = privateKeyEncryptToHex(src, privateKey);
        System.err.println(privateKeyEncrypt);

        String publicKeyDecrypt = publicKeyDecypt(privateKeyEncrypt, publicKey);
        System.err.println(publicKeyDecrypt);

    }
}
