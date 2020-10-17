FROM java:8
VOLUME /tmptest
ADD target/*.jar /jar/app.jar
EXPOSE 18000
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone
ENV PARAMS=""
ENV PACKAGE=""
#ENTRYPOINT [ "java $PARAMS", "-jar", "/jar/app.jar" ]
#PARAMS=-Dspring.profiles.active=jpx
#PACKAGE=-Dlog4j.skipJansi=false
ENTRYPOINT ["sh","-c","java $PARAMS $PACKAGE -jar /jar/app.jar"]