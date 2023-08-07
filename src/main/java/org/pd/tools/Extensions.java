package org.pd.tools;

public class Extensions {

    public static void printByteArray(byte[] byteArray) {
        StringBuilder sb = new StringBuilder();
        for (byte bit : byteArray) {
            sb.append(bit).append(",");
        }
        //10,18,8,-56,1,18,7,83,117,99,99,101,115,115,26,4,70,76,65,71
        System.out.println("Serialized Data to byteArray: " +  sb.substring(0, sb.length() - 1));

    }
}
