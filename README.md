> **Disclaimer**: Please Note that this is a research project. I am by no means responsible for any usage of this tool. Use on your own behalf. I’m also not responsible if your accounts get banned due to extensive use of this tool.

# jinstabot
[![GitHub license](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://github.com/alaptseu/jinstabot/blob/master/LICENSE)
[![built with Selenium](https://img.shields.io/badge/built%20with-Selenium-red.svg)](https://github.com/SeleniumHQ/selenium)

### Instagram Like, Comment and Follow Automation library

> Automation Script for “farming” Likes, Comments and Followers on Instagram. 

Implemented in Java using the Selenium module.

* **Run from command line**

[download latest jar](https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=com.github.alaptseu&a=jinstabot&v=1.0-SNAPSHOT&e=jar&c=jar-with-dependencies)  
[download WebDriver for Chrome](https://sites.google.com/a/chromium.org/chromedriver/)

`Example`: java -jar jinstabot-1.0-SNAPSHOT-jar-with-dependencies.jar -username <YOUR_USERNAME> -password <YOUR_PASSWORD> -driver <PATH TO chromedriver> -tags australia -comment true -follow true -comments nice!

Parameters can be specified in *.property file as well and passed to application as an argument,
for `example`: java -jar jinstabot-1.0-SNAPSHOT-jar-with-dependencies.jar -f <PATH TO YOUR *.property file>

Please note if -f (file) is specified AND any other option will be ignored.

**List of available options**:  
    _-comment_ - if set to true posts will be commented. Default: false  
    _-comments_ - comments you want to insert. One or many.  
    _-driver_ - path to driver. This is mandatory parameter.   
    _-file_ - properties file,if specified  has higher priority than other options.  
    _-follow_ - if set to true other accounts will be followed. Default: false
    _-username_ - instagram username, mandatory parameter.  
    _-password_ - instagram password, guess what it's mandatory as well   
    _-tags_ - tags you want to hit, one or many can be passed.  
    

* **Maven Integration**

If you're using Maven in your project, then you can integrate jInstagram by adding the following dependency in your pom.xml
	
```xml
<repositories>
  <repository>
     <id>oss.snapshots</id>
     <name>OSS Sonatype Snapshot Repository</name>
      <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
      <releases>
       <enabled>false</enabled>
      </releases>
      <snapshots>
       <enabled>true</enabled>
      </snapshots>
  </repository>
</repositories>

<dependency>
   <groupId>com.github.alaptseu</groupId>
   <artifactId>jinstabot</artifactId>
   <version>1.0-SNAPSHOT</version>
</dependency>
```

Examples for API usage:  
`Properties props = ...//load properties with options`  
`new InstaActionManager(new DefaultContext(props)).manager.run();`  

or  

`File file = ...//file with options`  
`new InstaActionManager(new DefaultContext(file)).manager.run();`

