package com.ic.IC74hc00;
public class pins {
    public enum INPUTPIN implements inputPinGet {
        A1(1),
        A2(4),
        A3(9),
        A4(12),
        B1(2),
        B2(5),
        B3(10),
        B4(13);

        private final int pin;

        INPUTPIN(int i) {
            this.pin = i;
        }
        @Override
        public int getPin() {
            return pin;
        }

        @Override
        public int getIndex() {
            return pin-1;
        }
    }


    enum OUTPUTPIN implements outputPinGet{
        Y1(3, INPUTPIN.A1, INPUTPIN.B1),
        Y2(6, INPUTPIN.A2, INPUTPIN.B2),
        Y3(8, INPUTPIN.A3, INPUTPIN.B3),
        Y4(11, INPUTPIN.A4, INPUTPIN.B4);

        private final int pin;
        INPUTPIN assossicatedAINPUTPIN, assossicatedBINPUTPIN;
        OUTPUTPIN(int i, INPUTPIN assossicatedAINPUTPIN, INPUTPIN assossicatedBINPUTPIN) {
            this.assossicatedAINPUTPIN = assossicatedAINPUTPIN;
            this.assossicatedBINPUTPIN = assossicatedBINPUTPIN;
            this.pin = i;
        }

        @Override
        public int getPin() {
            return pin;
        }

        @Override
        public int getIndex() {
            return pin-1;
        }
    }
}
interface inputPinGet    {
    int getPin();
    int getIndex();
}
interface outputPinGet  {
    int getPin();
    int getIndex();
}
