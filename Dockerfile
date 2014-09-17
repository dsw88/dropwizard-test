FROM docker-registry.vip.fsglobal.net/fs-java7-debian7

RUN mkdir -p /webapp

ADD target/dropwizard-test.jar /webapp/
ADD hello-world.yml /webapp/

CMD java -jar /webapp/dropwizard-test.jar server /webapp/hello-world.yml
