package com.cr.tools;

import java.awt.image.BufferedImage;

import org.imgscalr.Scalr;

public class ResizeImage {

    public static BufferedImage newSizeImage(BufferedImage srcImage, int targetWidth, int targetHeight) {

        return Scalr.resize(srcImage, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, targetWidth, targetHeight,
                Scalr.OP_ANTIALIAS);
    }
}
