package com.yl.encrypt;

/**
 * @author Alex
 * @since 2019/1/21 14:37
 */
public class ByteUtils {

    public static void main(String[] args) {
        System.err.println(getByteStr("s"));
    }
    /**
     * 获取字符串的二进制字符串
     * @param s
     * @return
     */
    public static String getByteStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (byte tbyte:s.getBytes()){
            /**
             * 0xFF:0x表示16进制,0xFF二进制为1111 1111
             * 作用:高24位置零,低八位保持不变(因为负数转成int前24位会补1)
             * 0x100:二进制为0001 0000 0000即再加上一位
             */
            int i = (tbyte & 0xFF) + 0x100;
            String bs = Integer.toBinaryString(i);
            String tString = bs.substring(1);
            sb.append(tString);
        }
        return sb.toString();
    }

    /**
     * 获取byte的二进制字符串
     */
    public static String getByteStr(byte b) {
        StringBuilder sb = new StringBuilder();
            /**
             * 0xFF:0x表示16进制,0xFF二进制为1111 1111
             * 作用:高24位置零,低八位保持不变(因为负数转成int前24位会补1)
             * 0x100:二进制为0001 0000 0000即再加上一位
             */
            int i = (b & 0xFF) + 0x100;
            String bs = Integer.toBinaryString(i);
            String tString = bs.substring(1);
            sb.append(tString);
        return sb.toString();
    }
    /**
     * 二行制转十六进制字符串
     */
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            /**
             * b[n] & 0XFF的意思
             * toHexString(int i) 如果传入一个负数byte,会将该byte转成int型数据
             * 假如byte i = -1,二进制为1111 1111;
             * 现在int j = i,二进制位1111 1111 1111 1111 1111 1111 1111 1111;
             * 转成十六进制的时候,本来是想转成FF,结果会转成FF FF FF FF
             * 而j & 0XFF时,会变成0000 0000 0000 0000 0000 0000 1111 1111
             * 转成十六进制的时候是FF,符合
             */
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
     * byte数组转int,4个字节转一个int
     * 从低位开始转
     * @param b
     * @return
     */
    public static int byteArrayToInt(byte[] b) {
        return b[3] & 0xFF |
            (b[2] & 0xFF) << 8 |
            (b[1] & 0xFF) << 16 |
            (b[0] & 0xFF) << 24;
    }

    /**
     * int转byte数组,每个int为4个byte
     * 高位放前面
     * @param a
     * @return
     */
    public static byte[] intToByteArray(int a) {
        return new byte[]{
            (byte) ((a >> 24) & 0xFF),
            (byte) ((a >> 16) & 0xFF),
            (byte) ((a >> 8) & 0xFF),
            (byte) (a & 0xFF)
        };
    }
}
