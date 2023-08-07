package org.pd.tools;import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    private static Map<String, Integer> sColorCacheMap = new HashMap();

    private Helper() {
    }

    public static String getMac(String mac) {
        if (mac.length() == 12) {
            String[] macs = new String[6];

            int i;
            for (i = 0; i <= 5; ++i) {
                macs[i] = mac.substring(i * 2, i * 2 + 2);
            }

            mac = macs[0];

            for (i = 1; i < macs.length; ++i) {
                mac = mac + ":" + macs[i];
            }

            return mac.toUpperCase();
        } else {
            return mac;
        }
    }

    public static String getTrimMac(String mac) {
        return mac.isEmpty() ? mac : mac.replaceAll(":", "").toUpperCase();
    }


    public static byte[] int2Bytes(int res) {
        byte[] result = new byte[]{(byte) (res >>> 24), (byte) (res >>> 16), (byte) (res >>> 8), (byte) res};
        return result;
    }

    public static int bytes2Int(byte[] res) {
        byte[] a = new byte[4];
        int i = a.length - 1;

        for (int j = res.length - 1; i >= 0; --j) {
            if (j >= 0) {
                a[i] = res[j];
            } else {
                a[i] = 0;
            }

            --i;
        }

        int v0 = (a[0] & 255) << 24;
        int v1 = (a[1] & 255) << 16;
        int v2 = (a[2] & 255) << 8;
        int v3 = a[3] & 255;
        return v0 + v1 + v2 + v3;
    }

    public static byte[] short2Bytes(short s) {
        byte[] desc = new byte[]{(byte) (s >> 0), (byte) (s >> 8)};
        return desc;
    }

    public static short bytes2Short(byte[] b) {
        return (short) (b[1] << 8 | b[0] & 255);
    }

    public static void logCaller(int index) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements != null) {
            if (index <= 0) {
                index = stackTraceElements.length;
            }

            index = Math.min(index, stackTraceElements.length);

            for (int i = 0; i < index; ++i) {
                System.out.println(stackTraceElements[i].getClassName() + "." + stackTraceElements[i].getMethodName());
            }
        }

    }

    public static void logCaller() {
        logCaller(4);
    }

    public static boolean emojiCompat() {
        return true;
    }


    public static String trimSpaceBetweenWrap(String input) {
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile("\n(\\s+)\n");
        Matcher m = p.matcher(input);

        while (m.find()) {
            m.appendReplacement(sb, m.group().replace(m.group(1), ""));
        }

        m.appendTail(sb);
        return sb.toString();
    }

    public static int[] getRatioArray(double[] array) {
        if (array == null) {
            return null;
        } else {
            int[] ratioArray = new int[array.length];
            double max = 0.0D;
            int maxIndex = 0;

            for (int i = 0; i < array.length; ++i) {
                if (array[i] > max) {
                    max = array[i];
                    maxIndex = i;
                }
            }

            double sum = 0.0D;

            int i;
            for (i = 0; i < array.length; ++i) {
                double temp = array[i] + 0.5D;
                array[i] = array[i] == 0.0D ? 0.0D : (array[i] <= 1.0D ? 1.0D : (double) ((int) temp));
                if (i != maxIndex) {
                    sum += array[i];
                }
            }

            array[maxIndex] = 100.0D - sum;

            for (i = 0; i < array.length; ++i) {
                ratioArray[i] = (int) array[i];
            }

            return ratioArray;
        }
    }
}
