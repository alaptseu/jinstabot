package com.jinstabot.action;

import com.jinstabot.context.Context;
import com.jinstabot.context.Credentials;
import com.jinstabot.context.IGCredentials;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * @author Alex L.
 */
public abstract class ActionAdaptor implements Action{

    protected final static String INSTA_URL = "https://www.instagram.com/";

    protected final Context context;

    protected ActionAdaptor(Context context) {
        this.context = context;
    }

    protected WebDriver getDriver() {
        return context.getDriver();
    }

    protected JavascriptExecutor getJavascriptExecutor(){
        return (JavascriptExecutor) getDriver();
    }

    protected Credentials getCredentials(){
        return context.getCredentials();
    }


    protected void goTo(String url) throws InterruptedException {
        getDriver().get(url);
        Thread.sleep(timeout());
    }
}
