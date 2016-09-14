package com.eap.wgjd.microblog;

/**
 * Created by evgenypavlenko on 1/19/16.
 */
public class TestBlog {
    public static void main(String...args) {

        MicroBlogNode local = new MicroBlogNode("localhost:8888");
        MicroBlogNode other = new MicroBlogNode("localhost:8988");
        //final Update first = new Update("1");
        Update.Builder ub1 = new Update.Builder();
        Update first = ub1.author(new Author()).updateText("1").build();
        //final Update second = new Update("2");
        Update.Builder ub2 = new Update.Builder();
        Update second = ub2.author(new Author()).updateText("2").build();

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

        new Thread((new Runnable() {
            @Override
            public void run() {
                local.propagateUpdate(first,other);
            }
        })).start();

        new Thread((new Runnable() {
            @Override
            public void run() {
                other.propagateUpdate(second,local);
            }
        })).start();
    }
}
