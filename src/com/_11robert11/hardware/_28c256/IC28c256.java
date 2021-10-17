package com._11robert11.hardware._28c256;


import com._11robert11.hardware.Hardware;
import com._11robert11.hardware.memory.Ram;
import com._11robert11.hardware.utils.interfaces.standardIC;
import com._11robert11.hardware.utils.interfaces.PinMapable;
import com._11robert11.hardware.utils.interfaces.Updatable;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class IC28c256  {
    boolean[] ioBuffer = new boolean[26];    //Not including VCC and Ground, starts at 0

    public IC28c256(int pins) {
    }

    enum MODE   {
        READ,
        BYTE_WRITE,
        PAGE_WRITE
    }

    MODE mode;

    public void updateLogic() throws ClassNotFoundException {
        System.out.println("3000");
        super.getClass().getClassLoader().loadClass("com._11robert11.hardware.pin1");

    }
    /*
    public IC28c256() throws IOException {
        super(10);
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

    @Override
    public void updatePins() {
        for (pin p: pin.values()) {
            p.value(ioBuffer[p.getIoBufferIndex()]);
        }
    }

    @Override
    public void updateIoBuffer() {
        for (pin p: pin.values()) {
            ioBuffer[p.getIoBufferIndex()] = p.value();
        }
    }

    @Override
    public void updateLogic() {
        if(!pin.CE.value() & pin.OU.value() & pin.WE.value()) {
            //When Chip Enable and Output Enable are low and Write Enable is High
            mode = MODE.READ;
        }
    }
    */

}
enum pieen implements PinMapable {
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
    CE,
    WE,
    OU,
    IO0,
    IO1,
    IO2,
    IO3,
    IO4,
    IO5,
    IO6,
    IO7;

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

