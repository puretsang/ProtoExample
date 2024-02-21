package org.pd;

import com.google.protobuf.ExtensionRegistryLite;
import org.pd.domain.DataProto;

import java.io.IOException;

public class LoginParse {

    private String binaryData = "10,3,8,-56,1,18,24,8,-62,-102,-117,1,18,9,85,115,101,114,32,55,55,50,57,90,6,98," +
            "114,50,52,103,97,26,32,55,52,100,99,50,98,51,100,102,54,50,54,52,56,48,52,48,48,48,48,49,98," +
            "100,54,98,100,57,56,55,50,102,102,42,-60,1,10,22,104,116,116,112,115,58,47,47,98,105,122,46," +
            "114,116,100,119,101,46,108,105,118,101,18,17,49,49,57,46,56,46,53,52,46,50,52,52,58,56,54,48," +
            "48,26,22,104,116,116,112,115,58,47,47,98,105,122,46,114,116,100,119,101,46,108,105,118,101," +
            "34,22,104,116,116,112,115,58,47,47,98,105,122,46,114,116,100,119,101,46,108,105,118,101,50," +
            "24,104,116,116,112,115,58,47,47,119,119,119,46,102,117,116,101,99,104,97,116,46,99,111,109" +
            ",58,24,104,116,116,112,115,58,47,47,108,111,103,105,110,46,114,116,100,119,101,46,108,105," +
            "118,101,66,25,104,116,116,112,115,58,47,47,98,97,99,107,117,112,46,114,116,100,119,101,46," +
            "108,105,118,101,74,20,119,115,115,58,47,47,119,115,115,46,114,116,100,119,101,46,108,105,118," +
            "101,80,1,88,1,56,-60,-119,-55,-116,-100,49,74,6,76,65,67,57,67,77,80,-96,32,88,-67,-111,-5," +
            "-84,-98,49,98,32,53,56,57,53,49,55,57,98,55,51,55,57,52,50,55,57,57,101,51,57,51,51,100,98," +
            "54,49,56,51,102,98,97,99";
    private String resulted = "10,3,8,-56,1";
    private ExtensionRegistryLite registryLite;

    public void readFile() throws IOException {
//        String[] binary =  binaryData.split(",");
//        byte[] byteArray = new byte[binary.length];
//        for (int i = 0; i < binary.length; i++) {
//            byteArray[i] = Integer.valueOf(binary[i]).byteValue();
//        }
        DataProto.Data obj = DataProto.Data.parseFrom(ByteArr.getByteResult());
        System.out.println(obj.toString());
    }



//    commonResult {
//        errCode: 200
//    }
//    user {
//        uid: 2671994
//        nickName: "\347\224\250\346\210\2665674"
//        identify: "bzc5a7"
//    }
//    sessionId: "b086c96fd34f19300000c6287fc045e7"
//    urls {
//        biz: "https://biz.rtdwe.live"
//        session: "119.8.54.244:8600"
//        friend: "https://biz.rtdwe.live"
//        group: "https://biz.rtdwe.live"
//        download: "https://www.futechat.com"
//        login: "https://login.rtdwe.live"
//        config: "https://backup.rtdwe.live"
//        wss: "wss://wss.rtdwe.live"
//        socketProtocol: 1
//        uploadServer: 1
//        uploadUrl: "http://ufile.bufag2.com:8080/upload"
//    }
//    serverTime: 1691660186209
//    inviteCode: "VW4Z6M"
//    privacy: 4128
//    disableTime: 1692264986203
//    agoraAppId: "5895179b737942799e3933db6183fbac"


    private String result = "commonResult {\n" +
            "  errCode: 200\n" +
            "}\n" +
            "user {\n" +
            "  uid: 2280770\n" +
            "  nickName: \"User 7729\"\n" +
            "  identify: \"br24ga\"\n" +
            "}\n" +
            "sessionId: \"74dc2b3df626480400001bd6bd9872ff\"\n" +
            "urls {\n" +
            "  biz: \"https://biz.rtdwe.live\"\n" +
            "  session: \"119.8.54.244:8600\"\n" +
            "  friend: \"https://biz.rtdwe.live\"\n" +
            "  group: \"https://biz.rtdwe.live\"\n" +
            "  download: \"https://www.futechat.com\"\n" +
            "  login: \"https://login.rtdwe.live\"\n" +
            "  config: \"https://backup.rtdwe.live\"\n" +
            "  wss: \"wss://wss.rtdwe.live\"\n" +
            "  socketProtocol: 1\n" +
            "  uploadServer: 1\n" +
            "}\n" +
            "serverTime: 1691169735876\n" +
            "inviteCode: \"LAC9CM\"\n" +
            "privacy: 4128\n" +
            "disableTime: 1691774535869\n" +
            "agoraAppId: \"5895179b737942799e3933db6183fbac\"\n";
}
