FROM tomcat:10.1-jdk17-temurin

RUN rm -rf /usr/local/tomcat/webapps/*
COPY FodderWebApp.war /usr/local/tomcat/webapps/FodderWebApp.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
