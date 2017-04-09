package com.jinstabot;

import com.beust.jcommander.JCommander;
import com.jinstabot.context.DefaultContext;
import com.jinstabot.manager.InstaActionManager;

/**
 * @author Alex L.
 */
public class JinstabotRunner {

    public static void main(String[] args) throws InterruptedException {
        Args argsWrapper = initArguments(args);
        new InstaActionManager(new DefaultContext(argsWrapper)).run();
    }

    private static Args initArguments(String[] args) {
        Args argsWrapper = new Args();
        JCommander jCommander = new JCommander();
        jCommander.addObject(argsWrapper);
        jCommander.usage();
        jCommander.parse(args);
        return argsWrapper;
    }
}
