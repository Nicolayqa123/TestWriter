package com;

import org.monte.screenrecorder.ScreenRecorder;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoRecord {
    private static ScreenRecorder screenRecorder;

    public static void startRecording() throws Exception {
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new ScreenRecorder(gc);
        screenRecorder.start();
    }

    public static void stopRecording(String recordName) throws Exception {
        //screenRecorder.stop();

        try {
            screenRecorder.stop();

            // переименовываем созданный .avi файл,
            if (recordName != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat(
                        "yyyy-MM-dd HH.mm.ss");
                String RECORD_DIRECTORY = "C:\\Programms\\PNG\\";
                File newFileName = new File(String.format("%s%s %s.avi",
                        RECORD_DIRECTORY, recordName,
                        dateFormat.format(new Date())));

                screenRecorder.getCreatedMovieFiles().get(0)
                        .renameTo(newFileName);
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
