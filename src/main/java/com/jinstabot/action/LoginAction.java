package com.jinstabot.action;

import com.jinstabot.context.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Alex L.
 */
public class LoginAction extends ActionAdaptor{

    public LoginAction(Context context) {
        super(context);
    }

    @Override
    public void execute() throws InterruptedException {
        WebElement signUpLink = getDriver().findElement(By.className("_fcn8k"));
        signUpLink.click();

        Thread.sleep(timeout());

        WebElement username = getDriver().findElement(By.name("username"));
        WebElement password = getDriver().findElement(By.name("password"));
        WebElement loginButton = getDriver().findElement(By.xpath("//*[@id=\"react-root\"]/section/main/article/div[2]/div[1]/div/form/span[1]/button"));

        Actions action = new Actions(getDriver());

        action.moveToElement(username).click().sendKeys(getCredentials().getUsername());

        action.moveToElement(password).click().sendKeys(getCredentials().getPassword());

        action.moveToElement(loginButton).click();
        action.perform();

        Thread.sleep(timeout());
    }

}
