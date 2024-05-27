FROM openjdk:17
ENV TZ=Asia/Seoul
COPY build/libs/TMT-BE-MemberServer-0.0.1.jar MemberServer.jar
ENTRYPOINT ["java", "-jar", "MemberServer.jar"]