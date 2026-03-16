FROM eclipse-temurin:21-jre-alpine
COPY target/*jar-with-dependencies.jar /usr/app/database-intro.jar
EXPOSE 8003
CMD ["java","-cp","/usr/app/superheroes.jar", "es.fplumara.dam1.superheroes.Main"]