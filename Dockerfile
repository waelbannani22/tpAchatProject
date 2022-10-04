FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/tpachatproject.war tpachatproject.war
ENTRYPOINT ["java","-jar","/tpachatproject.war"]
