FROM openjdk:8-alpine

MAINTAINER André Muniz

ADD target/aulaUNIPE.jar aulaUNIPE.jar

CMD java -jar aulaUNIPE.jar