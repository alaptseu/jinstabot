package com.jinstabot;

import com.beust.jcommander.JCommander;
import com.jinstabot.context.DefaultContext;
import com.jinstabot.manager.InstaActionManager;

import static com.jinstabot.utils.FileUtils.loadProperties;

/**
 * @author Alex L.
 */
public class JinstabotRunner {

    public static void main(String[] args) throws InterruptedException {
        Args argsWrapper = initArguments(args);
        InstaActionManager manager;
        if (argsWrapper.getFile() != null) {
            manager = new InstaActionManager(new DefaultContext(loadProperties(argsWrapper.getFile())));
        }else {
            manager = new InstaActionManager(new DefaultContext(argsWrapper));
        }
        manager.run();
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
