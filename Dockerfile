FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/tpAchatProject.war tpAchatProject.war
ENTRYPOINT ["java","-jar","/tpAchatProject.war"]
