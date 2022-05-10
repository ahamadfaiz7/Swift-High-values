
FROM openjdk:17-alpine
RUN addgroup -S appuser && adduser -S appuser -G appuser
USER appuser:appuser
WORKDIR /app
VOLUME /tmp
COPY build/libs/flexpay-auth-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 5002

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
