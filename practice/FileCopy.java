package net.leafwolf.FileFetcher;

import java.io.*;
import java.util.Random;

public class FileCopy {
    public static boolean copyTo(File src, File dest, String destFileName) {
        Random r = new Random();
        int fileRandom = r.nextInt();
        if (!src.exists()) {
            System.out.println("[WARN]" + " " + JudgeFileType.getCurrentTime() + " File can not be found!");
            return false;
        } else if ((new File(dest.getAbsolutePath() + "\\" + fileRandom + destFileName)).exists()) {
            System.out.println("[WARN] " + JudgeFileType.getCurrentTime() + " " + "File exists! Nothing is done to the original file!");
            return false;
        }
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        byte[] buffer = new byte[1024 * 16];
        int effectiveRead;
        try {
            bi = new BufferedInputStream(new FileInputStream(src));
            bo = new BufferedOutputStream(new FileOutputStream(dest.getAbsolutePath() + "\\" + fileRandom + destFileName));
            while ((effectiveRead = bi.read(buffer)) != -1) {
                bo.write(buffer, 0, effectiveRead);
            }
        } catch (IOException e) {
            System.out.println("[ERROR] " + JudgeFileType.getCurrentTime() + " " + e.toString());
            return false;
        } finally {
            if (bi != null && bo != null) {
                try {
                    bo.flush();
                    bo.close();
                    bi.close();
                } catch (IOException e) {
                    System.out.println("[ERROR] " + JudgeFileType.getCurrentTime() + " " + e.toString());
                }
            } else {
                System.out.println("[WARN] " + JudgeFileType.getCurrentTime() + " " + "Stream close error! Please check your system config!!!");
                return false;
            }
        }
        System.out.println("[SUCCESS] " + JudgeFileType.getCurrentTime() + " " + "File:[" + src.getName() + "] is copied to [" + dest.getName() + destFileName + "]");
        return true;
    }
}
