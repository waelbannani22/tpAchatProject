FROM openjdk:8-jdk-alpine
EXPOSE 8083
RUN wget -O tpAchatProject-1.0.war http://172.10.0.140:8081/repository/maven-snapshots/com/esprit/examen/tpAchatProject/1.0-SNAPSHOT/tpAchatProject-1.0-20221102.003034-1.war
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.war"]
