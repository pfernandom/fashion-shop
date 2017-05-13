FROM openjdk:8-jre-alpine

COPY target/web-client-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,suspend=n -jar /app.jar" ]