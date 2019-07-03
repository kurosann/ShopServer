package com.example.demo.Utils;

import java.io.File;

public class UploadUtils {
    public static final String IMG_RATH_PREFIX = "static/upload/img";

    public static File getImgDirFile() {
        String fileDirPath = "src/main/resources/" + IMG_RATH_PREFIX;

        File fileDir = new File(fileDirPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        return fileDir;
    }
}
