package com.eap.wgjd.microblog;

/**
 * Created by evgenypavlenko on 1/19/16.
 */
public class TestBlog {
    public static void main(String...args) {
        final MicroBlogNode local = new MicroBlogNode("localhost:8888");
        final MicroBlogNode other = new MicroBlogNode("localhost:8988");
        //final Update first = new Update("1");
        final Update.Builder ub1 = new Update.Builder();
        final Update first = ub1.author(new Author()).updateText("1").build();
        //final Update second = new Update("2");
        final Update.Builder ub2 = new Update.Builder();
        final Update second = ub2.author(new Author()).updateText("2").build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                local.propagateUpdate(first,other);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                other.propagateUpdate(second,local);
            }
        }).start();
    }
}
