package org.pd;

import com.google.protobuf.InvalidProtocolBufferException;
import org.pd.domain.DataProto;
import org.pd.tools.Extensions;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

       new LoginParse().readFile();
    }

    private static void objToByteArray() {
        DataProto.CommonResult commonResult = DataProto.CommonResult.newBuilder()
                .setErrCode(200)
                .setErrMsg("Success")
                .setFlag("FLAG")
                .build();
        DataProto.Data data = DataProto.Data.newBuilder().setCommentResult(commonResult).build();
        Extensions.printByteArray(data.toByteArray());
    }

    private static void byteArrayToObject() throws InvalidProtocolBufferException {
        byte[] byteArray = {10, 18, 8, -56, 1, 18, 7, 83, 117, 99, 99, 101, 115, 115, 26, 4, 70, 76, 65, 71};
        DataProto.Data obj = DataProto.Data.parseFrom(byteArray);
        System.out.println(obj.toString());
    }


}