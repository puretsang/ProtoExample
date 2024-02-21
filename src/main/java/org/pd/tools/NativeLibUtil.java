package org.pd.tools;

import java.security.MessageDigest;

public class NativeLibUtil {
    private static final char[] DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String sign2(String data) {
        try {
            //@z90JqzxT9sWTqDQ3ajQE
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update((data + "!@#b%^&*9").getBytes());
            return new String(encodeHex(messageDigest.digest()));
        } catch (Exception e) {
            return "";
        }
    }

    public static String md5(String str) {
        if (str == null) {
            return null;
        } else {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return new String(encodeHex(messageDigest.digest()));
            } catch (Exception var2) {
                throw new RuntimeException(var2);
            }
        }
    }

    private static char[] encodeHex(byte[] data) {
        int l = data.length;
        char[] out = new char[l << 1];
        int i = 0;

        for (int var4 = 0; i < l; ++i) {
            out[var4++] = DIGITS_LOWER[(240 & data[i]) >>> 4];
            out[var4++] = DIGITS_LOWER[15 & data[i]];
        }

        return out;
    }

    private static String HEX_STR = "0123456789ABCDEF";

    public static byte[] hexStringToByteArray (String hexString) {
//hexstring的长度对2取整，作为bytes的长度
        int len = hexString. length () /2;
        byte [] bytes = new byte [len];
        byte high = 0;//字节高四位
        byte low = 0;//字节低四位
        for (int i=0;i<len; i++){
            //右移四位得到高位
            high = (byte) ((HEX_STR.indexOf (hexString.charAt (2*i)))<<4);
            low = (byte)HEX_STR.indexOf(hexString.charAt(2*i+1));
            bytes[i] = (byte)(high|low);//高地位做或运算
        }
        return bytes;
    }

    public static byte[] hexToBuffer(String hexString) throws NumberFormatException {
        int length = hexString.length();
        byte[] buffer = new byte[(length + 1) / 2];
        boolean evenByte = true;
        byte nextByte = 0;
        int bufferOffset = 0;

        // If given an odd-length input string, there is an implicit
        // leading '0' that is not being given to us in the string.
        // In that case, act as if we had processed a '0' first.
        // It's sufficient to set evenByte to false, and leave nextChar
        // as zero which is what it would be if we handled a '0'.
        if ((length % 2) == 1)
            evenByte = false;

        for (int i = 0; i < length; i++) {
            char c = hexString.charAt(i);
            int nibble;    // A "nibble" is 4 bits: a decimal 0..15

            if ((c >= '0') && (c <= '9'))
                nibble = c - '0';
            else if ((c >= 'A') && (c <= 'F'))
                nibble = c - 'A' + 0x0A;
            else if ((c >= 'a') && (c <= 'f'))
                nibble = c - 'a' + 0x0A;
            else
                throw new NumberFormatException("Invalid hex digit '" + c + "'.");

            if (evenByte) {
                nextByte = (byte) (nibble << 4);
            } else {
                nextByte += (byte) nibble;
                buffer[bufferOffset++] = nextByte;
            }

            evenByte = !evenByte;
        }

        return buffer;
    }

}
