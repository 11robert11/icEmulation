package com._11robert11.hardware.utils.interfaces;

public interface PinMapable {
    int getIoBufferIndex();
    void setIoBufferIndex(int ioBufferIndex);
    boolean value(boolean value);
    boolean value();

}
