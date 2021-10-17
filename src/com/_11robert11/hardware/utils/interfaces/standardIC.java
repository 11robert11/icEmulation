package com._11robert11.hardware.utils.interfaces;

import java.util.Arrays;

/***
 * Implemnts the basic IO needed to use an IC
 */
public interface standardIC {
    boolean getIO(int i);
    boolean[] getIO(int startIndex, int endIndex);
    void setIO(int i, boolean value);
    void setIO(int i, boolean[] value);

}
