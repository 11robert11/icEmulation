package com.ic.utils.interfaces;

import java.util.Arrays;

public interface standardIC {
    boolean getIO(int i);
    boolean[] getIO(int startIndex, int endIndex);
    void setIO(int i, boolean value);
    void setIO(int i, boolean[] value);
}
