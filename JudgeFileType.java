package net.leafwolf.FileFetcher;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class JudgeFileType {
    private static final String[] typeOfImage = {"JPG", "JPEG", "PNG", "GIF", "JFIF", "TIFF", "BMP", "SVG"};
    private static final String[] typeOfVideo = {"WMV", "ASF", "ASX", "RM", "RMVB", "MP4", "MP3", "3GP", "MOV", "M4V", "AVI", "MKV", "FLV", "VOB"};
    private static final ArrayList<String> imageType = toArrayList(typeOfImage);
    private static final ArrayList<String> videoType = toArrayList(typeOfVideo);

    public static boolean isImage(File file) {
        String name = file.getName().toUpperCase();
        int index = name.lastIndexOf(".");
        name = name.substring(index + 1);
        return imageType.contains(name);
    }

    public static boolean isVideo(File file) {
        String name = file.getName().toUpperCase();
        int index = name.lastIndexOf(".");
        name = name.substring(index + 1);
        return videoType.contains(name);
    }

    public static boolean isVideoOrImage(File file) {
        return isImage(file) || isVideo(file);
    }

    public static ArrayList<String> toArrayList(String[] arr) {
        ArrayList<String> temArr = new ArrayList<>();
        Collections.addAll(temArr, arr);
        return temArr;
    }

    public static String getCurrentTime() {
        Date dt = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(dt);
    }

    public static String getPostfix(File f) {
        String name = f.getName();
        int index = name.lastIndexOf(".");
        name = name.substring(index);
        return name;
    }
}
