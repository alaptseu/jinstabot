package com.jinstabot.action;

import com.jinstabot.data.Data;

/**
 * @author Alex L.
 */
public interface CallBack {

    void onComplete(Iterable<? extends Data> result);

}
