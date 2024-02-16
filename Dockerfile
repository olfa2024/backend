FROM gradle:jdk11 as BUILD

COPY --chown=gradle:gradle . /project
RUN gradle -i -s -b /project/build.gradle clean build

FROM eclipse-temurin:11-jre-slim
ENV PORT 8082
EXPOSE 8082

COPY --from=BUILD /project/build/libs/* /opt/
WORKDIR /opt/
RUN ls -l
CMD ["/bin/bash", "-c", "find -type f -name '*SNAPSHOT.jar' | xargs java -jar"]
