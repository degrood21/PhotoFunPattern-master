package edu.up.cs371.epp.photofunpattern;

import android.graphics.Color;

/**
 *  class GrayFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to convert the image to gray scale.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class GrayFilter extends PhotoFilter {

    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It transforms a color pixel to gray by averaging its three RGB
    * components.
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components is their averaged
    * value
    */
    public int transformPixel(int inPixel) {
        int redintensity = Color.red(inPixel);
        int greenintensity = Color.green(inPixel);
        int blueintensity = Color.blue(inPixel);
        return Color.argb(255, redintensity,greenintensity,blueintensity);
    }

}
