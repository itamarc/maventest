#
# Build stage
#
FROM maven:3.8.1-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
COPY src/main/resources/* /home/app/templates/
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/maventest-0.1.jar /usr/local/lib/maventest-0.1.jar
COPY --from=build /home/app/templates/* /home/app/templates/
RUN mkdir /home/app/doc
ENTRYPOINT ["java","-jar","/usr/local/lib/maventest-0.1.jar","/home/app/templates", "/home/app/doc"]
