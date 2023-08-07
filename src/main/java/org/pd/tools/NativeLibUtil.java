package org.pd.tools;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class NativeLibUtil {

    private NativeLibUtil() {
    }

    private static class SingletonHolder {
        public static final NativeLibUtil INSTANCE = new NativeLibUtil();
    }

    public static NativeLibUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * HTTP\SOCKET 加密
     *
     * @param data
     * @param mode       1:加密 2:解密
     * @return
     */
    public byte[] sign1(byte[] data, int mode) {
        synchronized (this) {
            try {
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                SecretKeySpec secretKeySpec = new SecretKeySpec("5I4SGU42ETFI4TQG".getBytes(), "AES");;
                cipher.init(mode, secretKeySpec);
                return cipher.doFinal(data);
            } catch (Exception e) {
                return new byte[0];
            }
        }
    }


}
