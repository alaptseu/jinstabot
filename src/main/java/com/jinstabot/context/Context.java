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

    Boolean isLogin();

    Set<String> getTags();

    List<String> getComments();

}
