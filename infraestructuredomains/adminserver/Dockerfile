FROM openjdk:11-jdk-alpine
#creamos un grupo de usuario para que solo el admin pueda ejecutar
RUN addgroup -S paymentchain && adduser -S admin -G paymentchain
USER admin:paymentchain
#montar una carpeta para agregar los archivos
VOLUME /tmp
ARG JAR_FILE=target/*.jar
# lo cambio el nombre de jar file a app.jar
ADD target/${JAR_FILE} app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]
