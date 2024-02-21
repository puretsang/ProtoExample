package org.pd.tools;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


/**
 * AES加解密类
 */
public class AESHelper {

    private AESHelper() {
    }

    public static String encrypt(byte[] messageBytes, String key) throws NullPointerException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return encrypt("AES/ECB/PKCS5Padding", messageBytes, key);
    }

    public static String decrypt(byte[] messageBytes, String key) throws NullPointerException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return decrypt("AES/ECB/PKCS5Padding", messageBytes, key);
    }

    public static byte[] decryptToBytes(byte[] messageBytes, String key) throws NullPointerException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return decryptToBytes("AES/ECB/PKCS5Padding", messageBytes, key);
    }

    public static String encrypt(String algorithm, byte[] messageBytes, String key) throws NullPointerException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (messageBytes == null) {
            throw new NullPointerException();
        }

        if (TextUtils.isEmpty(key) || key.length() < 16) {
            throw new BadPaddingException();
        }

        final String ALGORITHM = "AES";
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.substring(0, 16).getBytes(), ALGORITHM));
        return HexString.bufferToHex(cipher.doFinal(messageBytes));
    }

    public static String encrypt1(byte[] messageBytes, String key) throws NullPointerException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (messageBytes == null) {
            throw new NullPointerException();
        }

        if (TextUtils.isEmpty(key) || key.length() < 16) {
            throw new BadPaddingException();
        }
        final String ALGORITHM = "AES";
        final String padding = "AES/ECB/PKCS7Padding";
        Cipher cipher = Cipher.getInstance(padding);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.substring(0, 16).getBytes(), ALGORITHM));
        return HexString.bufferToHex(cipher.doFinal(messageBytes));
    }

    public static String decrypt1(byte[] messageBytes, String key) throws NullPointerException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (messageBytes == null) {
            throw new NullPointerException();
        }

        if (TextUtils.isEmpty(key) || key.length() < 16) {
            throw new BadPaddingException();
        }

        final String ALGORITHM = "AES";
        final String padding = "AES//ECB/PKCS5PADDING";
        Cipher cipher = Cipher.getInstance(padding);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.substring(0, 16).getBytes(), ALGORITHM));
        return new String(cipher.doFinal(messageBytes));
    }

    public static String decrypt(String algorithm, byte[] messageBytes, String key) throws NullPointerException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (messageBytes == null) {
            throw new NullPointerException();
        }

        if (TextUtils.isEmpty(key) || key.length() < 16) {
            throw new BadPaddingException();
        }

        final String ALGORITHM = "AES";
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.substring(0, 16).getBytes(), ALGORITHM));
        return new String(cipher.doFinal(messageBytes));
    }

    public static byte[] decryptToBytes(String algorithm, byte[] messageBytes, String key) throws NullPointerException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (messageBytes == null) {
            throw new NullPointerException();
        }

        if (TextUtils.isEmpty(key) || key.length() < 16) {
            throw new BadPaddingException();
        }

        final String ALGORITHM = "AES";
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.substring(0, 16).getBytes(), ALGORITHM));
        return cipher.doFinal(messageBytes);
    }

    /**
     * 初始化 AES Cipher
     *
     * @param key
     * @param cipherMode
     * @return
     */
    private static Cipher initAESCipher(byte[] key, int cipherMode) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        final String ALGORITHM = "AES";
        final String ALGORITHM_STR = "AES/ECB/PKCS7Padding";
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
        cipher.init(cipherMode, new SecretKeySpec(key, ALGORITHM));
        return cipher;
    }

    public static byte[] encryptBytes(String key, byte[] sourceBytes) throws NullPointerException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (TextUtils.isEmpty(key) || key.length() < 16) {
            throw new BadPaddingException();
        }

        ByteArrayInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new ByteArrayInputStream(sourceBytes);
            out = new ByteArrayOutputStream();

            Cipher cipher = initAESCipher(key.substring(0, 16).getBytes(), Cipher.ENCRYPT_MODE);
            byte[] buffer = new byte[1024 * 100];
            int length;
            while ((length = in.read(buffer)) != -1) {
                byte[] data = cipher.doFinal(buffer, 0, length);
                out.write(data, 0, data.length);
            }
            byte[] data = out.toByteArray();
            return data;
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return null;
    }

    public static byte[] decryptBytes(String key, byte[] sourceBytes) throws NullPointerException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (TextUtils.isEmpty(key) || key.length() < 16) {
            throw new BadPaddingException();
        }

        ByteArrayInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new ByteArrayInputStream(sourceBytes);
            out = new ByteArrayOutputStream();

            Cipher cipher = initAESCipher(key.substring(0, 16).getBytes(), Cipher.DECRYPT_MODE);

            byte[] buffer = new byte[1024 * 100 + 16];
            int length;
            while ((length = in.read(buffer)) != -1) {
                byte[] data = cipher.doFinal(buffer, 0, length);
                out.write(data, 0, data.length);
            }
            byte[] data = out.toByteArray();
            return data;
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return null;
    }

    /**
     * 随机生成密码
     *
     * @param length 密码的长度
     * @return 最终生成的密码
     */
    public static String generatePassword(int length) {
        // 最终生成的密码
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 随机生成0或1，用来确定是当前使用数字还是字母 (0则输出数字，1则输出字母)
            int charOrNum = random.nextInt();
            if (charOrNum == 1) {
                // 随机生成0或1，用来判断是大写字母还是小写字母 (0则输出小写字母，1则输出大写字母)
                password.append(random.nextInt(26) + random.nextInt(2) == 1 ? 65 : 97);
            } else {
                // 生成随机数字
                password.append(random.nextInt(10));
            }
        }
        return password.toString();
    }

    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String gp16 = "G0oWr7ttd0lMg5tZ";
//        String targetUserKey = "863BD5D0852A3697F32CA98B8611EF35CF1A257FB437D14F84DFFC3A47464E7F";
        String targetUserKey = "863BD5D0852A3697F32CA98B8611EF35CF1A257FB437D14F84DFFC3A47464E7F";
        String answer = encrypt(gp16.getBytes(), targetUserKey);
        System.out.println("secretKey ===> " + answer);
    }

    public interface CryptProgressListener {
        boolean progress(long currentPosition, long totalPosition);
    }
}
