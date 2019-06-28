package com.example.demo.Utils;

import ch.qos.logback.core.net.server.Client;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.File;
import java.net.URI;

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
