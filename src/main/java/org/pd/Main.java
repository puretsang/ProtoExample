package org.pd;

import com.google.protobuf.InvalidProtocolBufferException;
import org.pd.domain.DataProto;
import org.pd.tools.Extensions;
import org.pd.tools.NativeLibUtil;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        String gp = generatePassword(16);
        System.out.println("generatePassword ===>"+ gp);
    }

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