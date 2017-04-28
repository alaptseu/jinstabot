package com.jinstabot.context;

import com.jinstabot.Args;
import com.jinstabot.context.IGCredentials.CredentialsBuilder;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Stream;

import static com.jinstabot.utils.FileUtils.loadProperties;
import static java.lang.Boolean.parseBoolean;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author Alex L.
 */
public final class DefaultContext implements Context{

    private IGCredentials credentials;

    private WebDriver driver;

    private Set<String> tags;

    private List<String> comments;

    private boolean follow;

    private boolean comment;

    public DefaultContext(final Args args) {
        if (args == null) {
            throw new IllegalArgumentException("No arguments specified");
        }
        initCredentials(args.getUsername(), args.getPassword());
        initDriver(args.getDriver());
        this.tags = new HashSet<>(args.getTags());
        this.comments = new ArrayList<>(args.getComments());
        this.follow = args.isFollow();
        this.comment = args.isComment();
    }

    public DefaultContext(final Properties properties) {
        if (properties == null) {
            throw new IllegalArgumentException("No properties specified");
        }
        initCredentials(properties.getProperty("username"), properties.getProperty("password"));
        initDriver(properties.getProperty("driver"));
        this.tags = Stream.of(properties.getProperty("tags"))
            .map(String::trim)
            .collect(toSet());
        this.comments = Stream.of(properties.getProperty("comments"))
            .map(String::trim)
            .collect(toList());
        this.follow = parseBoolean(properties.getProperty("follow"));
        this.comment = parseBoolean(properties.getProperty("comment"));
    }

    public DefaultContext(final File file) {
        this(loadProperties(file));
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

    public WebDriver getDriver() {
        return driver;
    }

    public Set<String> getTags() {
        return tags;
    }

    public List<String> getComments() {
        return comments;
    }

    @Override
    public String getXpath(String key) {
        throw new NotImplementedException("Implement me");
    }

    @Override
    public String getTagName(String key) {
        throw new NotImplementedException("Implement me");
    }

    @Override
    public String getClassName(String key) {
        throw new NotImplementedException("Implement me");
    }

    @Override
    public String getName(String key) {
        throw new NotImplementedException("Implement me");
    }

    public boolean isFollow() {
        return follow;
    }

    @Override
    public boolean isComment() {
        return comment;
    }
}
