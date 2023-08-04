FROM openjdk:17.0-jdk
RUN mkdir /APP
WORKDIR /APP
COPY target/DrugRegistry-Search-0.0.1-SNAPSHOT.jar  /APP/DrugRegistry-Search-0.0.1-SNAPSHOT.jar
EXPOSE 3434
RUN chmod -R 777 /APP
ENTRYPOINT ["java","-jar","/APP/DrugRegistry-Search-0.0.1-SNAPSHOT.jar"]
