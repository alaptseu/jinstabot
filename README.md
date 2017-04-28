> **Disclaimer**: Please Note that this is a research project. I am by no means responsible for any usage of this tool. Use on your own behalf. I’m also not responsible if your accounts get banned due to extensive use of this tool.

# jinstabot
[![GitHub license](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://github.com/alaptseu/jinstabot/blob/master/LICENSE)
[![built with Selenium](https://img.shields.io/badge/built%20with-Selenium-red.svg)](https://github.com/SeleniumHQ/selenium)

### Instagram Like, Comment and Follow Automation library

> Automation Script for “farming” Likes, Comments and Followers on Instagram. 

Implemented in Java using the Selenium module.

* Maven Integration

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