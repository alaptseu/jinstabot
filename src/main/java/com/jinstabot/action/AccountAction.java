package com.jinstabot.action;

import com.jinstabot.context.Context;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;

/**
 * @author Alex L.
 */
public class AccountAction extends ActionAdaptor{

    private Log log = LogFactory.getLog(getClass());

    private final static String FOLLOWING = "following";

    private final static String FOLLOWERS = "followers";

    public AccountAction(Context context) {
        super(context);
    }

    @Override
    public void execute(CallBack callBack) throws InterruptedException {
        goTo(INSTA_URL.concat(context.getCredentials().getUsername()).concat("/"));
        WebElement mainElem = getDriver().findElement(By.tagName("main"));
        List<WebElement> linkElements = mainElem.findElements(By.tagName("a"));
        Set<WebElement> infoElements = linkElements.stream().
            filter(webElement -> of(FOLLOWING, FOLLOWERS).anyMatch(webElement.getAttribute("href")::contains)).collect(toSet());
        for(WebElement webElement : infoElements){
            final String text = webElement.getText();
            log.info(text);
        }

    }

}
