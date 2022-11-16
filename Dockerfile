FROM openjdk:8-jdk-alpine
EXPOSE 8089
RUN wget -O tpAchatProject-1.1.war http://172.10.0.140:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.1/tpAchatProject-1.1.war
ENTRYPOINT ["java","-jar","/tpAchatProject-1.1.war"]
