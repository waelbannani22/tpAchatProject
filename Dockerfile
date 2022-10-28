FROM openjdk:8-jdk-alpine
EXPOSE 8083
RUN wget http://192.168.33.10:8081/#browse/browse:maven-releases:com%2Fesprit%2Fexamen%2FtpAchatProject%2F1.0%2FtpAchatProject-1.0.war tpAchatProject-1.0.war
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.war"]
