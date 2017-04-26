package com.jinstabot.context;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Set;

/**
 * @author Alex L.
 */
public interface Context {

    String WEBDRIVER__CHROME_DRIVER = "webdriver.chrome.driver";

    Credentials getCredentials();

    WebDriver getDriver();

    Set<String> getTags();

    List<String> getComments();

    String getXpath(String key);

    String getTagName(String key);

    String getClassName(String key);

    String getName(String key);

    boolean isFollow();

}
