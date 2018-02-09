package edu.up.cs371.epp.photofunpattern;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 *  class PhotoFilter is the abstract filter parent class. Its default behavior
 *  is the leave an image unchanged.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */
public abstract class PhotoFilter {

    /*
    * constrain This method does not permit an RGB color value to over or under
    * saturate. It maintains values between 0 and 255 inclusive.
    *
    * @param inPixel is an integer input color component value that may be out
    *                of range
    * @return a new color component in range
    */
    protected int constrain(int color) {
        if (color > 255)
            return 255;
        else if (color < 0)
            return 0;
        else
            return color;
    }

    /*
    * tranformPixel This is the default transform method. It leaves the pixel
    * unchanged. It implements a copy image function.
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which unchanged color components
    */
    protected int transformPixel (int inPixel, int pixel1, int pixel2, int pixel3, int pixel4, int pixel5, int pixel6, int pixel7, int pixel8){
        int outPixel = 0;
        int redPixel;
        int greenPixel;
        int bluePixel;
        redPixel = (Color.red(inPixel) + Color.red(pixel1) + Color.red(pixel2) + Color.red(pixel3) + Color.red(pixel4) + Color.red(pixel4) + Color.red(pixel5) + Color.red(pixel6) + Color.red(pixel7) + Color.red(pixel8))/9;
        greenPixel = (Color.green(inPixel) + Color.green(pixel1) + Color.green(pixel2) + Color.green(pixel3) + Color.green(pixel4) + Color.green(pixel4) + Color.green(pixel5) + Color.green(pixel6) + Color.green(pixel7) + Color.green(pixel8))/9;
        bluePixel = (Color.blue(inPixel) + Color.blue(pixel1) + Color.blue(pixel2) + Color.blue(pixel3) + Color.blue(pixel4) + Color.blue(pixel4) + Color.blue(pixel5) + Color.blue(pixel6) + Color.blue(pixel7) + Color.blue(pixel8))/9;
        outPixel = Color.argb(255, redPixel,greenPixel,bluePixel);
        return outPixel;
    }

    /*
    * apply This method visits every pixel in the input image. It applies a
    * transform to each pixel.
    *
    * @param inBmp is the original image
    * @return a new image in which each pixel has been transformed
    */
    public Bitmap apply(Bitmap inBmp) {
        int width = inBmp.getWidth();
        int height = inBmp.getHeight();

        Bitmap newBmp = Bitmap.createBitmap(width, height, inBmp.getConfig());

        for (int w = 1; w < width-1; w = w + 3) {
            for (int h = 1; h < height-1; h = h + 3) {
                //int inPixel = inBmp.getPixel(w,h);
                int outPixel = transformPixel(
                        inBmp.getPixel(w,h),
                        inBmp.getPixel(w-1,h-1),
                        inBmp.getPixel(w-1,h),
                        inBmp.getPixel(w,h-1),
                        inBmp.getPixel(w+1,h+1),
                        inBmp.getPixel(w+1,h-1),
                        inBmp.getPixel(w+1,h),
                        inBmp.getPixel(w,h+1),
                        inBmp.getPixel(w-1,h+1)
                );

                        newBmp.setPixel(w,h, outPixel);
                        newBmp.setPixel(w-1,h-1, outPixel);
                        newBmp.setPixel(w-1,h, outPixel);
                        newBmp.setPixel(w,h-1, outPixel);
                        newBmp.setPixel(w+1,h+1, outPixel);
                        newBmp.setPixel(w+1,h-1, outPixel);
                        newBmp.setPixel(w+1,h, outPixel);
                        newBmp.setPixel(w,h+1, outPixel);
                        newBmp.setPixel(w-1,h+1, outPixel);
            }
        }

        return newBmp;
    }
}
