package com.jinstabot.action.workflow;

import com.jinstabot.context.Context;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author Alex L.
 */
public class TagWorkflowAction extends TagWorkFlowTemplate {

    private Log log = LogFactory.getLog(getClass());

    private final String TAG_URL = "https://www.instagram.com/explore/tags/";

    public TagWorkflowAction(Context context) {
        super(context);
    }

    @Override
    public void doUnlike(WebElement webElement) throws InterruptedException {

    }

    @Override
    public void doFollow(WebElement webElement) throws InterruptedException {
        if (!context.isFollow()){
            return;
        }
        WebElement followButton = getDriver().findElement(By.xpath("//article/header/span/button"));
        Thread.sleep(timeout());
        if (followButton.getText().startsWith("Follow")) {
            followButton.click();
        }
    }

    @Override
    public void doComment(WebElement webElement) throws InterruptedException {
        WebElement commentInput = getDriver().findElement(By.xpath("//input[@placeholder = 'Add a comment…']"));
        commentInput.sendKeys(getRandomComment());
        commentInput.submit();
        Thread.sleep(timeout());
    }

    @Override
    public void doLike(WebElement webElement) throws InterruptedException {
        JavascriptExecutor jse = getJavascriptExecutor();
        jse.executeScript("document.getElementsByClassName('" + webElement.getAttribute("class") + "')[0].click()");
        Thread.sleep(timeout());
    }

    public Set<String> getTagLinks(final String tag) throws InterruptedException {
        if (isBlank(tag)) {
            throw new IllegalArgumentException("Tag is not specified");
        }
        getDriver().get(TAG_URL.concat(tag));
        Thread.sleep(timeout());
        WebElement bodyElement = getDriver().findElement(By.tagName("body"));
        Thread.sleep(timeout());
        WebElement loadButton = bodyElement.findElement(By.xpath("//a[contains(@class, \"_8imhp _glz1g\")]"));
        bodyElement.sendKeys(Keys.END);
        Thread.sleep(timeout());
        loadButton.click();
        bodyElement.sendKeys(Keys.HOME);
        Thread.sleep(timeout());
        WebElement main_elem = getDriver().findElement(By.tagName("main"));
        List<WebElement> link_elems = main_elem.findElements(By.tagName("a"));
        return link_elems.stream().map(webElement -> webElement.getAttribute("href")).collect(toSet());
    }

}
