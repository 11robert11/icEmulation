package com._11robert11.hardware.utils;

import com._11robert11.hardware.utils.interfaces.PinMapable;
import com._11robert11.hardware.utils.interfaces.standardIC;
import com._11robert11.test.tempTest;
public class Pin extends tempTest{

    enum pin implements PinMapable {
        A1,
        A2,
        A3,
        A4,

        B1,
        B2,
        B3,
        B4,

        Y1,
        Y2,
        Y3,
        Y4;

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
}
