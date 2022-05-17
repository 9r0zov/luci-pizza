FROM openjdk:17-alpine as build
WORKDIR /app

COPY . .

RUN ./gradlew build
#RUN mkdir -p build/libs && (cd build/libs; jar -xf ../*.jar)

FROM openjdk:17-alpine AS luci-pizza
EXPOSE 80
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]