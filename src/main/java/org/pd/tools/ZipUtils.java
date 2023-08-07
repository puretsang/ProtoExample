package org.pd.tools;


import java.io.*;
import java.util.zip.GZIPInputStream;

public class ZipUtils {

    private static final int BUFFER_SIZE = 4096;

    public ZipUtils() {
    }

    public static byte[] unGZip(byte[] data) throws Exception {
        GZIPInputStream gzin = null;
        try {
            gzin = new GZIPInputStream(new ByteArrayInputStream(data));
            return readAllBytes(gzin);
        } catch (Exception var3) {
            var3.printStackTrace();
        } finally {
            gzin.close();
        }
        return null;
    }

    public static byte[] readAllBytes(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        copyAllBytes(in, out);
        return out.toByteArray();
    }

    public static int copyAllBytes(InputStream in, OutputStream out) throws IOException {
        int byteCount = 0;
        byte[] buffer = new byte[BUFFER_SIZE];
        while (true) {
            int read = in.read(buffer);
            if (read == -1) {
                break;
            }
            out.write(buffer, 0, read);
            byteCount += read;
        }
        return byteCount;
    }


}
