package com.jinstabot.action.workflow;

import com.jinstabot.action.ActionAdaptor;
import com.jinstabot.action.CallBack;
import com.jinstabot.context.Context;
import com.jinstabot.data.TagData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.lang.String.format;

/**
 * @author Alex L.
 */
public abstract class TagWorkFlowTemplate extends ActionAdaptor {

    private Log log = LogFactory.getLog(getClass());

    protected TagWorkFlowTemplate(Context context) {
        super(context);
    }

    @Override
    public void execute(CallBack callBack) throws InterruptedException {
        for (String tag : context.getTags()) {
            log.info(format("Tag - %s: ", tag));
            Set<String> links = getTagLinks(tag);
            log.info(format("Number of links %s: ", links.size()));
            Set<TagData> tagDataSet = new HashSet<>(links.size());
            for (String url : links) {
                tagDataSet.add(handleLink(url, tag));
            }
            if (callBack != null) {
                callBack.onComplete(tagDataSet);
            }
        }
    }

    protected TagData handleLink(String url, String tag) throws InterruptedException {
        log.info(url);
        TagData tagData = new TagData();
        tagData.setTag(tag);
        tagData.setLink(url);
        goTo(url);
        List<WebElement> toLikeElements = getDriver().findElements(By.xpath("//a[@role = 'button']/span[text()='Like']"));
        List<WebElement> likedElements = getDriver().findElements(By.xpath("//a[@role = 'button']/span[text()='Unlike']"));
        if (toLikeElements.size() == 1) {
            WebElement likeElement = toLikeElements.get(0);
            tagData.setLikeElement(likeElement);
            doLike(likeElement);
            doComment(likeElement);
            doFollow(likeElement);
        } else if (likedElements.size() == 1) {
            tagData.setLikedElement(likedElements.get(0));
            doUnlike(likedElements.get(0));
        }
        return tagData;
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
