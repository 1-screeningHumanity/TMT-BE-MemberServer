FROM openjdk:17
COPY build/libs/TMT-BE-MemberServer-0.0.1.jar MemberServer.jar
ENTRYPOINT ["java", "-jar", "MemberServer.jar"]