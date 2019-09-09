# TellRawLib
A simple library that allows you to send JSON messages on spigot
servers without NMS.

### Functionality
**As a plugin (TODO)**
- Broadcast a JSON formatted message to your server
- Send a JSON formatted message to a user/group of users on your server
- An easy to use GUI that allows you to build the JSON message

**As an API**
- Send raw JSON messages to your server without needing to 
write any NMS

### Building
Only the API:
`mvn install -pl plugin`
Only the plugin:
`mvn package -pl plugin`

### Using this library

Maven
```xml
<dependency>
  <groupId>net.derpz.tellrawlib</groupId>
  <artifactId>api</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

Gradle
```groovy
implementation 'net.derpz.tellrawlib:api:1.0.0-SNAPSHOT'
```
