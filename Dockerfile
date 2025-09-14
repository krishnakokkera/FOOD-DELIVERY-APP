# Use official Tomcat image with JDK 17
FROM tomcat:10.1-jdk17-temurin

# Optional: Clean default webapps (removes examples and docs)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR file into Tomcat's webapps folder
COPY FodderWebApp.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080 for web traffic
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
