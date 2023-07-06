FROM maven:3.8.2-eclipse-temurin-17
WORKDIR /bookshelf-api
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run