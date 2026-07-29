FROM tomcat:10.1-jdk17-temurin

WORKDIR /build
COPY web /build/web
COPY src/java /build/src

RUN rm -rf /build/web/WEB-INF/classes && \
    mkdir -p /build/web/WEB-INF/classes && \
    javac -encoding UTF-8 \
      -cp "/usr/local/tomcat/lib/*:/build/web/WEB-INF/lib/*" \
      -d /build/web/WEB-INF/classes \
      $(find /build/src -name "*.java") && \
    rm -rf /usr/local/tomcat/webapps/ROOT && \
    cp -r /build/web /usr/local/tomcat/webapps/ROOT

EXPOSE 8080
CMD ["catalina.sh", "run"]
