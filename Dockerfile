FROM tomcat:10.1-jdk17-temurin

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR file into Tomcat
COPY FodderWebApp.war /usr/local/tomcat/webapps/FodderWebApp.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
