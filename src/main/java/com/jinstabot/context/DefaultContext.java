package com.jinstabot.context;

import com.jinstabot.Args;
import com.jinstabot.context.IGCredentials.CredentialsBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author Alex L.
 */
public class DefaultContext implements Context{

    private IGCredentials credentials;

    private Boolean login = Boolean.TRUE;

    private WebDriver driver;

    private Set<String> tags;

    private List<String> comments;

    public DefaultContext(final Args args) {
        if (args == null) {
            throw new IllegalArgumentException("No arguments specified");
        }
        initCredentials(args.getUsername(), args.getPassword());
        this.login = args.isLogin();
        initDriver(args.getDriver());
        this.tags = new HashSet<>(args.getTags());
        this.comments = new ArrayList<>(args.getComments());
    }

    public DefaultContext(final Properties properties) {
        if (properties == null) {
            throw new IllegalArgumentException("No properties specified");
        }
        initCredentials(properties.getProperty("username"), properties.getProperty("password"));
        this.login = Boolean.valueOf(properties.getProperty("login"));
        initDriver(properties.getProperty("driver"));
        this.tags = Stream.of(properties.getProperty("tags"))
            .map(String::trim)
            .collect(toSet());
        this.comments = Stream.of(properties.getProperty("comments"))
            .map(String::trim)
            .collect(toList());
    }

    private void initDriver(final String driverPath) {
        System.setProperty(WEBDRIVER__CHROME_DRIVER, driverPath);
        this.driver = new ChromeDriver();
    }

    private void initCredentials(final String username, final String password) {
        this.credentials = new CredentialsBuilder()
            .withUsername(username)
            .withPassword(password)
            .build();
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public Boolean isLogin() {
        return login;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Set<String> getTags() {
        return tags;
    }

    public List<String> getComments() {
        return comments;
    }
}
