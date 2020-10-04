FROM moxm/java:1.8-full

MAINTAINER wmxing97@foxmail.com

ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom"

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /marco-gateway

WORKDIR /marco-gateway

EXPOSE 3000

ADD ./target/marco-gateway-1.0.jar ./

CMD sleep 60;java $JAVA_OPTS -jar marco-gateway-1.0.jar