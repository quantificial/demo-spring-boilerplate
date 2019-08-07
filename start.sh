nohup java -Xms1024m -Xmx2g -XX:+UseG1GC -XX:MetaspaceSize=1g -XX:MaxMetaspaceSize=2g -jar target/demo-spring-boilerplate-0.0.1-SNAPSHOT.jar --server.port=9080 > app.log 2>&1 & echo $! > app.pid
