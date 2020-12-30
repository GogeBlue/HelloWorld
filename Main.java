package net.leafwolf.FileFetcher;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        sc.useDelimiter("\n");
        String type = "";
        String src = "";
        String dest = "";
        System.out.println("Please enter the file type which you wish to copy([i]image only,[v]video only,[b]both image and vedio)：");
        type = sc2.next().toLowerCase();
        System.out.println("Type the source directory(absolute path):");
        src = sc.next();
        System.out.println("Type the output directory(absolute path)：");
        dest = sc.next();
        File s = new File(src);
        File d = new File(dest);
        if ("i".equals(type)) {
            sortImage(s, d);
        } else if ("v".equals(type)) {
            sortVideo(s, d);
        } else if ("b".equals(type)) {
            sortBoth(s, d);
        } else {
            System.out.println("Type not found!");
        }
    }

    private static void sortImage(File inputDir, File outputDir) {
        File[] files = inputDir.listFiles();
        String filename = "";
        for (File file : files) {
            if (file.isFile() && JudgeFileType.isImage(file)) {
                filename = JudgeFileType.getCurrentTime() + JudgeFileType.getPostfix(file);
                FileCopy.copyTo(file, outputDir, filename);
            } else if (!file.isFile()) {
                sortImage(file, outputDir);
            }
        }
    }

    private static void sortVideo(File inputDir, File outputDir) {
        File[] files = inputDir.listFiles();
        String filename = "";
        for (File file : files) {
            if (file.isFile() && JudgeFileType.isVideo(file)) {
                filename = JudgeFileType.getCurrentTime() + JudgeFileType.getPostfix(file);
                FileCopy.copyTo(file, outputDir, filename);
            } else if (!file.isFile()) {
                sortVideo(file, outputDir);
            }
        }
    }

    private static void sortBoth(File inputDir, File outputDir) {
        File[] files = inputDir.listFiles();
        String filename = "";
        for (File file : files) {
            if (file.isFile() && JudgeFileType.isVideoOrImage(file)) {
                filename = JudgeFileType.getCurrentTime() + JudgeFileType.getPostfix(file);
                FileCopy.copyTo(file, outputDir, filename);
            } else if (!file.isFile()) {
                sortBoth(file, outputDir);
            }
        }
    }

}
