FROM amazoncorretto:25

ARG MAVEN_VERSION=3.9.16
ENV MAVEN_HOME=/opt/maven
ENV PATH=${MAVEN_HOME}/bin:${PATH}

RUN dnf install -y tar gzip which && dnf clean all

RUN curl -fsSL "https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz" \
      -o /tmp/maven.tar.gz \
 && mkdir -p ${MAVEN_HOME} \
 && tar -xzf /tmp/maven.tar.gz -C ${MAVEN_HOME} --strip-components=1 \
 && rm /tmp/maven.tar.gz

WORKDIR /app

EXPOSE 8080

CMD ["sleep", "infinity"]
