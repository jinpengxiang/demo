FROM java:8
VOLUME /tmptest
ADD target/*.jar /jar/app.jar
EXPOSE 18400
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone

## 设置系统字符
#ENV  LANG="en_US.UTF-8"

ENV PARAMS=""
ENV PACKAGE=""
#ENTRYPOINT [ "java $PARAMS", "-jar", "/jar/app.jar" ]
ENTRYPOINT ["sh","-c","java $PARAMS $PACKAGE -jar /jar/app.jar"]