FROM maven:3.9.2 as builder
ENV TZ=Asia/Bangkok
COPY .m2/ /root/.m2
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17
ENV APPNAME training-api-0.0.1
COPY --from=builder /app/target/${APPNAME}.jar /${APPNAME}.jar
EXPOSE 8081
# ENTRYPOINT ["java"]
#CMD ["sh", "-c", "java -jar ${APPNAME}.jar"]
ENTRYPOINT ["java", "-jar", "training-api-0.0.1.jar"]
#HEALTHCHECK CMD curl --fail http://localhost:8081/${APPNAME}
