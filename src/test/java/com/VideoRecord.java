package com;

import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;

public class VideoRecord {
    private static ScreenRecorder screenRecorder;

    public static void startRecording() throws Exception {
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new ScreenRecorder(gc);
        screenRecorder.start();
    }

    public static void stopRecording() throws Exception {
        screenRecorder.stop();
    }
}
