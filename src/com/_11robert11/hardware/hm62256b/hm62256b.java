package com._11robert11.hardware.hm62256b;

import com._11robert11.hardware.utils.interfaces.PinMapable;
import com._11robert11.hardware.utils.interfaces.Updatable;
import com._11robert11.hardware.utils.interfaces.standardIC;

import java.util.Arrays;

public class hm62256b implements Updatable, standardIC {
    boolean[] ioBuffer = new boolean[24];
    MODE mode = MODE.STANDBY;
    @Override
    public void updatePins() {
        for (pin p: pin.values()) {
            ioBuffer[p.getIoBufferIndex()] = p.value();
        }
    }

    @Override
    public void updateIoBuffer() {

    }

    @Override
    public void updateLogic() {

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
        for(int a = i; a < value.length; a++)  {
            ioBuffer[a] = value[a];
        }
    }

    static enum MODE {
        STANDBY,
        OUTPUT_DISABLE,
        READ,
        WRITE
    }
    public hm62256b()   {

    }
}
enum pin implements PinMapable {
    A0,
    A1,
    A2,
    A3,
    A4,
    A5,
    A6,
    A7,
    A8,
    A9,
    A10,
    A11,
    A12,
    A13,
    A14,
    IO0,
    IO1,
    IO2,
    IO3,
    IO4,
    IO5,
    IO6,
    IO7,
    CS,
    WE,
    OE;

    private boolean value;
    private int ioBufferIndex;
    standardIC standardic;

    @Override
    public boolean value() {
        return value;
    }

    @Override
    public boolean value(boolean value) {
        return value;
    }

    @Override
    public void setIoBufferIndex(int ioBufferIndex) {
        this.ioBufferIndex = ioBufferIndex;
    }

    @Override
    public int getIoBufferIndex() {
        return ioBufferIndex;
    }
}

