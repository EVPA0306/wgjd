package com.eap.wgjd.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by evgenypavlenko on 8/11/16.
 */
public class StyleWithFuture {
    public static void main(String...args) {
        try {
            Path file = Paths.get("/Users/evgenypavlenko/Projects/wgjd/data/logs/clust3.log");

            AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);
            ByteBuffer buffer = ByteBuffer.allocate(100_000);
            Future<Integer> result = channel.read(buffer,0);

            while (!result.isDone()) {
                System.out.println("Calculating...");
            }

            Integer bytes_read = result.get();
            System.out.println("Bytes read [" + bytes_read + "]");

        } catch (IOException | ExecutionException | InterruptedException ex ) {
            System.out.println(ex.getMessage());
        }
    }
}
