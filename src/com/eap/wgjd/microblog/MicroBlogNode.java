package com.eap.wgjd.microblog;

/**
 * Created by evgenypavlenko on 1/19/16.
 */
public class MicroBlogNode extends SimpleMicroBlog {
    private final String identifier;

    public MicroBlogNode(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public synchronized void propagateUpdate(Update update, MicroBlogNode backup) {
        System.out.println(identifier + ": received:  " + update.getUpdateText()
                + " ; backup: "+backup.getIdentifier());
        backup.confirmUpdate(this, update);
    }

    public synchronized void confirmUpdate(MicroBlogNode other, Update update) {
        System.out.println(identifier + ": received confirm: " + update.getUpdateText()
                + " from " + other.getIdentifier());
    }
}
