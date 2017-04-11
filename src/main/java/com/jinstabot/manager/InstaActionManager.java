package com.jinstabot.manager;

import com.jinstabot.action.CallBack;
import com.jinstabot.action.GoToAction;
import com.jinstabot.action.workflow.TagWorkflowAction;
import com.jinstabot.action.LoginAction;
import com.jinstabot.context.DefaultContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Alex L.
 */
public class InstaActionManager implements CallBack{

    private Log log = LogFactory.getLog(getClass());

    private final String INSTA_URL = "https://www.instagram.com/";

    private final DefaultContext context;

    public InstaActionManager(DefaultContext context) {
        this.context = context;
    }

    public void run() throws InterruptedException {
        log.info("Starting...");
        new GoToAction(context, INSTA_URL).execute(this);
        if (context.isLogin()) {
            new LoginAction(context).execute(this);
        }
        new TagWorkflowAction(context).execute(this);
    }

    @Override
    public void callback() {

    }
}
