# ProtoExample

## 项目描述

- java 集成protobuf（maven项目）Demo
- clone 到本地，然后在Terminal执行  mvn protobuf:compile ,DataProto.java 会生成在target/generated-sources/protobuf/java/org/pd/domain/DataProto.java
- 将DataProto.java move 到你需要的文件里 即可。
- 如果需要生成Object,在proto目前创建Object.proto, 然后执行 mvn protobuf:compile 即可

