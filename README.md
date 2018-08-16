# AdaptTo 2018 - ToughDay2 Sling Test Example

## Configuring the repo.adobe.com

In order to be able to access parent poms and dependencies, you will have to configure repo.adobe.com in your settings.xml.

Please follow the instructions from [here](https://helpx.adobe.com/experience-manager/kb/SetUpTheAdobeMavenRepository.html)

## Download latest ToughDay2 jar
Please download the latest ToughDay2 jar from [here](https://repo.adobe.com/nexus/content/repositories/releases/com/adobe/qe/toughday2/)

## Starting Sling Standalone
For starting sling standlone please use the instructions from [here](https://sling.apache.org/documentation/getting-started.html#sling-download-1)

## Building the test
```bash
mvn clean install
```

## Executing the test
If you look in the code you will see that there is a `SlingHello` test. In order to find information about it you can execute
```bash
java -jar toughday2.jar --help SlingHello --add path/to/sling-test-sample-0.1.0-SNAPSHOT.jar
```

* Execute from CLI without parameter

```bash
java -jar toughday2.jar --add SlingHello --add path/to/sling-test-sample-0.1.0-SNAPSHOT.jar --host=localhost --port=8080 --installsamplecontent=false
```


* Execute from the CLI with parameter

```bash
java -jar toughday2.jar --help SlingHello path=/index.html --add path/to/sling-test-sample-0.1.0-SNAPSHOT.jar --host=localhost --port=8080 --installsamplecontent=false
```

* Execute using an YAML configuration

```bash
java -jar toughday2.jar --configfile=sling-td2-config.yaml
```
