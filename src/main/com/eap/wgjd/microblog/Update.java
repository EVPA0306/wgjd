package com.eap.wgjd.microblog;

/**
 * Created by evgenypavlenko on 1/19/16.
 */
public class Update {
    private final String updateText;
    private final Author author;

    /*
    public Update(String updateText) {
        this.updateText = updateText;
        this.author = null;
    }

    public Update(String updateText, Author author) {
        this.updateText = updateText;
        this.author = author;
    }
    */

    private Update(Builder builder) {
        this.author = builder.author;
        this.updateText = builder.updateText;
    }

    public String getUpdateText() {
        return updateText;
    }

        public static class Builder implements ObjectBuilder {
            private Author author;
            private String updateText;


            public Builder author(Author author) {
                this.author = author;
                return this;
            }

            public Builder updateText(String updateText) {
                this.updateText = updateText;
                return this;
            }

            @Override
            public Update build() {
                return new Update(this);
            }
        }
}
