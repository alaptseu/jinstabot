package com.jinstabot.action;

import com.jinstabot.context.Context;

/**
 * @author Alex L.
 */
public class GoToAction extends ActionAdaptor{

    private final String url;

    public GoToAction(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    public void execute() {
        getDriver().get(url);
    }
}
