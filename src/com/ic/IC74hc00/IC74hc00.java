package com.ic.IC74hc00;


public class IC74hc00 extends pins {
    boolean[] io = new boolean[13];
    public void setInput(inputPinGet pin, boolean input)   {
        io[pin.getPin()-1] = input;
    }
    public boolean getOutput(outputPinGet pin)  {
        return io[pin.getPin()-1];
    }
    public void update()    {
        for (pins.OUTPUTPIN outputpin: pins.OUTPUTPIN.values()) {
            io[outputpin.getIndex()] = io[
                    outputpin.assossicatedAINPUTPIN.getIndex()]
                    &&
                    io[outputpin.assossicatedBINPUTPIN.getIndex()];
        }
    }
}