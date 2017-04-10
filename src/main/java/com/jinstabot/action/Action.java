package com.jinstabot.action;

/**
 * @author Alex L.
 */
public interface Action {

    void execute(CallBack callBack) throws InterruptedException;

    default long timeout(){
        return 3000;
    }

    default String comment(){
        return "Cool!";
    }
}
