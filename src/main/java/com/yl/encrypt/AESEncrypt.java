package com.yl.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Alex
 * @since 2019/3/26 17:28
 */
public class AESEncrypt {

    private static final String AES = "AES";
    /**
     * 加密
     */
    public static byte[] encrypt(byte[] src, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), AES);
        cipher.init(Cipher.ENCRYPT_MODE, securekey);//设置密钥和加密形式
        return cipher.doFinal(src);
    }

    /**
     * 二行制转十六进制字符串
     */
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase();
    }

    /**
     * 将十六进制字符串转成二进制字节数组
     * @param b
     * @return
     */
    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("长度不是偶数");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    /**
     * 加密
     */
    public final static String encrypt(String data, String key) {
        try {
            // 将加密得到的二进制字节数组转成十六进制字符串
            return byte2hex(encrypt(data.getBytes(), key));
        } catch (Exception e) {
        }
        return null;
    }

    public static byte[] decrypt(byte[] src,String key) throws Exception{
        Cipher cipher = Cipher.getInstance(AES);
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(src);
    }

    /**
     * 解密
     * 密文需为十六进制字符串
     * @param hexStr
     * @param key
     * @return
     */
    public static String decryptToString(String hexStr,String key){
        try {
            byte[] decrypt = decrypt(hex2byte(hexStr.getBytes()), key);
            return new String(decrypt);
        }catch (Exception e){

        }
        return null;
    }


    public static void main(String[] args) {
        String encrypt = "153A963924671D26715788DF29DEFDEAD6157A1F735DCD94094B4BDB264BBCE5208AD67BDF33F4CBD63D2E0CDB286FB50F0BCD9AAA546E5D4A15E5405FC70ACB5EAEA412E3EFF1026D98617A61963FC9";

        System.err.println(decryptToString(encrypt, "nbDLUw1eqV53HPwT"));
    }
}
