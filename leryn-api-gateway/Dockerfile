FROM docker.leryn.top/maven:3.8.4-openjdk-17-slim as build

WORKDIR /opt

COPY settings.xml  /usr/share/maven/conf/settings.xml
COPY pom.xml       pom.xml

RUN mvn -B dependency:go-offline --fail-never

COPY . .

RUN mvn package -Dmaven.test.skip=true

FROM docker.leryn.top/openjdk:17-oracle as publish

WORKDIR /opt

COPY --from=build /opt/*.jar ./app.jar

ENV JAVA_OPTS=""

EXPOSE 8080/tcp

ENTRYPOINT exec java ${JAVA_OPTS} -jar app.jar