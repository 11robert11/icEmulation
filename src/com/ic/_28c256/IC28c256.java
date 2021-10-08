package com.ic._28c256;


import com.ic.utils.interfaces.Updatable;
import com.ic.utils.interfaces.standardIC;

import java.util.Arrays;

public class IC28c256 implements standardIC, Updatable {
    boolean[] ioBuffer = new boolean[26];    //Not including VCC and Ground, starts at 0
    public IC28c256()   {

    }
    @Override
    public boolean getIO(int i) {
        return ioBuffer[i-1];
    }

    @Override
    public boolean[] getIO(int startIndex, int endIndex) {
        return Arrays.copyOfRange(ioBuffer, startIndex, endIndex);
    }

    @Override
    public void setIO(int i, boolean value) {
        ioBuffer[i] = value;
    }

    @Override
    public void setIO(int i, boolean[] value) {

    }

    @Override
    public void update() {

    }
}
