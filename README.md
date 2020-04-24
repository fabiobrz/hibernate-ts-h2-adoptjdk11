# hibernate-ts-h2-adoptjdk11
Reproducer for Hibernate ORM issues using H2 when running on Adopt OpenJDK 11.0.6

## Steps to reproduce

### Get a Wildfly/JBoss distribution you want to test with
https://wildfly.org/downloads/

### Clone this repo
```
git clone git@github.com:fabiobrz/hibernate-ts-h2-adoptjdk11.git
```

### Build the reproducer
```
mvn clean install
```

### Copy the generated `war` into the Wildfly/JBoss deployment directory
```
cp target/hibernate-ts-h2-adoptjdk11.war <JBOSS_HOME>/standalone/deployments/
```

### Set the JAVA_HOME environment variable to the home of your Eclipse Adopt OpenJDK 11 base
```
JAVA_HOME=~/.sdkman/candidates/java/11.0.6.j9-adpt
```

### Start Wildfly/JBoss
```
<JBOSS_HOME>/bin/standalone.sh
```
