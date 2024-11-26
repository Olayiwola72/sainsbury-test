!#/bin/bash
mvn clean install -Dmaven.test.skip=true
java -jar -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 target/*.jar
