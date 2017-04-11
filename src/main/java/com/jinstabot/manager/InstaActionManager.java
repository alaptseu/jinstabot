package com.jinstabot.manager;

import com.jinstabot.action.CallBack;
import com.jinstabot.action.LoginAction;
import com.jinstabot.action.workflow.TagWorkflowAction;
import com.jinstabot.context.DefaultContext;
import com.jinstabot.data.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Alex L.
 */
public class InstaActionManager implements CallBack {

    private Log log = LogFactory.getLog(getClass());

    private final DefaultContext context;

    public InstaActionManager(DefaultContext context) {
        this.context = context;
    }

    public void run() throws InterruptedException {
        log.info("Starting...");
        new LoginAction(context).execute(this);
        new TagWorkflowAction(context).execute(this);
    }

    @Override
    public void onComplete(Iterable<? extends Data> result) {

    }
}
