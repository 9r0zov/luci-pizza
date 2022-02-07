FROM openjdk:17-alpine AS luci-pizza
EXPOSE 80
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]