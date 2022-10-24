FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/tpAchatProject-1.0.RELEASE.war tpAchatProject-1.0.RELEASE.war
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.RELEASE.war"]
