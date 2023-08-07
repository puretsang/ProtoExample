package org.pd;

import org.pd.tools.Extensions;
import org.pd.tools.ParseRespBytes;

import java.io.IOException;
import java.io.InputStream;

public class LoginParse {

    public void readFile() throws IOException {
        InputStream inputStream = Main.class.getResourceAsStream("/aaa.uu");
        if (inputStream != null) {
            byte[] bytes = inputStream.readAllBytes();
            byte[] byteArray = ParseRespBytes.parseRespBytes(bytes);
            //   val result = parser.parseFrom(contentBuffer)
            Extensions.printByteArray(byteArray);
        }
    }
}
