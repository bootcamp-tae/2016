# 2016

TOPICS:

* JUnit - http://junit.org/junit4/

* TestNG - http://testng.org/doc/documentation-main.html

* Selenium Webdriver + Locators - http://www.seleniumhq.org/docs/

* JBehave - http://jbehave.org/reference/latest/

* Good Practices in Web Test Automation:

    * Page Object Pattern 
    * Asserts and data validation

BEFORE BEGINNING TO WORK:

* JDK 8 + Variable de entorno JAVA_HOME seteada a path de instalacion JDK 8

* Maven + Path _<Maven_path>/bin_ agregado a variable de entorno **PATH**

* Dentro de las oficinas de Globant, el archivo de configuración de Maven en _[HOME]/.m2/settings.xml_ debe tener el siguiente contenido:

```xml
<settings>
    <proxies>
        <proxy>
            <id>globant-proxy</id>
            <active>true</active>
            <protocol>http</protocol>
            <host>proxy.corp.globant.com</host>
            <port>3128</port>
            <username></username>
            <password></password>
            <nonProxyHosts>127.0.0.1</nonProxyHosts>
        </proxy>
    </proxies>
</settings>
```

* Configuration para plugin compilador Maven para Java 1.8
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.6.0</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
    </plugins>
</build>
```
