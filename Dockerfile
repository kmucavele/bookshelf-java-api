FROM openjdk:18
ADD target/bookshelf-api.jar bookshelf-api.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "bookshelf-api.jar"]