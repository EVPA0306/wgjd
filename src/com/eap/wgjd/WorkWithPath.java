package com.eap.wgjd;

import java.nio.file.*;
import java.io.IOException;
import java.nio.file.attribute.*;

public class WorkWithPath {
	
	public static void main(String...args) throws IOException {
		
//		Path listing = Paths.get("C:\\Temp");
//		System.out.println(listing.getFileName());
//		System.out.println(listing.getParent());
//		System.out.println(listing.getNameCount());
//		System.out.println(listing.getRoot());
//		System.out.println(listing.subpath(0,3));
//
//		try(DirectoryStream<Path> stream = Files.newDirectoryStream(listing,"*.*")) {
//			for (Path entry: stream) {
//				System.out.println(entry.getFileName());
//			}
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
		
		Path startDir = Paths.get("/");
        //Files.walkFileTree(startDir, new FindJavaVisitor());
        Files.walkFileTree(startDir, new FindVirusedFileVisitor());


		
	}

    private static class FindVirusedFileVisitor extends SimpleFileVisitor<Path>{
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().contains("HELP_DECRYPT")) {
                System.out.println("File has been deleted: " + file.toAbsolutePath().toString() + "\\" + file.getFileName());
                Files.delete(file);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs) throws IOException {
            //System.out.println(file.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            if ( exc != null) {
                System.out.println("Access denided to " + file.toAbsolutePath().toString());
            }
            return FileVisitResult.CONTINUE;
        }
    }

	/*private static class FindJavaVisitor extends SimpleFileVisitor<Path> {
		
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
			//if (file.toString().endsWith(".java")) {
			if (file.toString().startsWith("HELP_DECRYPT.")) {
				System.out.println(file.getFileName());
			}
			return FileVisitResult.CONTINUE;
		}
	}*/
}