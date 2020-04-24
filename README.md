# hibernate-ts-h2-adoptjdk11
Reproducer for Hibernate ORM issues using H2 when running on Adopt OpenJDK 11.0.6

## Description
Hibernate ORM TS is failing some H2 test cases executed on *Eclipse OpenJ9 VM AdoptOpenJDK (v. 11.0.6)*, see https://hibernate.atlassian.net/browse/HHH-13966

This reproducer was created to assess that the failure is not showing up in Wildfly/JBoss when this is using the above mentioned JDK.

Most of the code is taken from Hibernate ORM test suite (https://github.com/hibernate/hibernate-orm/blob/5.3.15/hibernate-core/src/test/java/org/hibernate/test/typeoverride/TypeOverrideTest.java) but was slightly refactored in order to allow for the test method to be called by a servlet.

Hibernate ORM version used in this project 5.3.15.

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
