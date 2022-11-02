FROM openjdk:8-jdk-alpine
EXPOSE 8083
RUN wget -O tpAchatProject-1.0.war http://http://172.10.0.140:8081/#browse/browse:maven-snapshots:com%2Fesprit%2Fexamen%2FtpAchatProject%2F1.0%2FtpAchatProject-1.0.war
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.war"]
