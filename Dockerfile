#FROM openjdk:21-jdk
#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:21-jdk
ADD build/libs/*.jar dockerapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "dockerapp.jar"]


taskkill /PID 4288 /F