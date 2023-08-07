package org.pd.tools;

public class ParseRespBytes {

    public static byte[] parseRespBytes(byte[] data) {
        try {
            if (BitUtils.checkBitValue(data[0], 7) && BitUtils.checkBitValue(data[0], 6)) {
                if (!BitUtils.checkBitValue(data[0], 5)
                        && !BitUtils.checkBitValue(data[0], 4)
                        && !BitUtils.checkBitValue(data[0], 3)
                        && !BitUtils.checkBitValue(data[0], 2)
                        && !BitUtils.checkBitValue(data[0], 1)
                        && !BitUtils.checkBitValue(data[0], 0)) {
                    byte[] contentBuffer = new byte[data.length - 6];
                    System.arraycopy(data, 6, contentBuffer, 0, contentBuffer.length);
                    boolean isEncrypt = BitUtils.checkBitValue(data[1], 7);
                    boolean isGzip = BitUtils.checkBitValue(data[1], 6);

                    if (isGzip) {
                        contentBuffer = ZipUtils.unGZip(contentBuffer);
                    }

                    if (isEncrypt) {
                        contentBuffer = NativeLibUtil.getInstance().sign1(contentBuffer, 2);
                    }

                    return contentBuffer;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
