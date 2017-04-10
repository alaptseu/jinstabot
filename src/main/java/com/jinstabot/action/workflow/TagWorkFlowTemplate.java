package com.jinstabot.action.workflow;

import com.jinstabot.action.ActionAdaptor;
import com.jinstabot.action.CallBack;
import com.jinstabot.context.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author Alex L.
 */
public abstract class TagWorkFlowTemplate extends ActionAdaptor {

    protected TagWorkFlowTemplate(Context context) {
        super(context);
    }

    @Override
    public void execute(CallBack callBack) throws InterruptedException {
        for (String tag : context.getTags()) {
            Set<String> links = getTagLinks(tag);
            for (String url : links) {
                getDriver().get(url);
                Thread.sleep(timeout());
                List<WebElement> toLikeElements = getDriver().findElements(By.xpath("//a[@role = 'button']/span[text()='Like']"));
                List<WebElement> likedElements = getDriver().findElements(By.xpath("//a[@role = 'button']/span[text()='Unlike']"));
                if (toLikeElements.size() == 1) {
                    doLike(toLikeElements.get(0));
                    doComment(toLikeElements.get(0));
                    doFollow(toLikeElements.get(0));
                } else if (likedElements.size() == 1) {
                    doUnlike(likedElements.get(0));
                }
            }
            if (callBack != null) {
                callBack.callback();
            }
        }
    }

    protected String getRandomComment() {
        try {
            return context.getComments().get((new Random()).nextInt(context.getComments().size()));
        }
        catch (Throwable e){
            return comment();
        }
    }

    public abstract void doUnlike(WebElement webElement) throws InterruptedException ;

    public abstract void doFollow(WebElement webElement) throws InterruptedException ;

    public abstract void doComment(WebElement webElement) throws InterruptedException ;

    public abstract void doLike(WebElement webElement) throws InterruptedException ;

    public abstract Set<String> getTagLinks(String tag) throws InterruptedException ;


}
