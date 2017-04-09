package com.jinstabot.context;


import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author Alex L.
 */
public class IGCredentials implements Credentials{

    private final String username;

    private final String password;

    private IGCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class CredentialsBuilder {

        private String username;

        private String password;

        public CredentialsBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public CredentialsBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public IGCredentials build() {
            if(isEmpty(password) || isEmpty(username)) {
                throw new IllegalArgumentException(format("Not valid username %s or password %s", username, password));
            }
            return new IGCredentials(username, password);
        }

    }
}
