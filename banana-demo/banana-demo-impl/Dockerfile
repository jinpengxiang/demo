FROM java:8
VOLUME /tmptest
ADD target/*.jar /jar/app.jar
EXPOSE 18400
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone

RUN localedef -c -f UTF-8 -i zh_CN zh_CN.utf8
ENV LC_ALL zh_CN.UTF-8

ENV PARAMS=""
ENV PACKAGE=""
#ENTRYPOINT [ "java $PARAMS", "-jar", "/jar/app.jar" ]
ENTRYPOINT ["sh","-c","java $PARAMS $PACKAGE -jar /jar/app.jar"]