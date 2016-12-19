# 2016

TOPICS:

* TestNG (TestNg Doc: http://testng.org/doc/documentation-main.html http://www.mkyong.com/tutorials/testng-tutorials/)

* Selenium Webdriver + Locators (Selenium Doc: http://www.seleniumhq.org/docs/)

* JBehave (Jbehave Documentation: http://jbehave.org/reference/latest/ http://jbehave.org/reference/web/stable/using-selenium.html)

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