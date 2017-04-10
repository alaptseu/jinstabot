package com.jinstabot;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.FileConverter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex L.
 */
public class Args {

    @Parameter(names = "-username", description = "instagram username", required = true)
    private String username;

    @Parameter(names = "-password", description = "instagram password", required = true)
    private String password;

    @Parameter(names = "-login", description = "Should login?",  arity = 1)
    private boolean login = true;

    @Parameter(names = "-driver", description = "Path to driver", required = true)
    private String driver;

    @Parameter(names = "-tags", description = "Tags you want to hit", variableArity = true)
    private List<String> tags = new ArrayList<>();

    @Parameter(names = "-comments", description = "Comments you want to paste", variableArity = true)
    private List<String> comments = new ArrayList<>();

    @Parameter(names = "-file", converter = FileConverter.class)
    private File file;

    @Parameter(names = "--help", help = true)
    private boolean help;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
