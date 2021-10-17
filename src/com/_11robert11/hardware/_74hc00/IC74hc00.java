package com._11robert11.hardware._74hc00;
import com._11robert11.hardware.utils.interfaces.PinMapable;
import com._11robert11.hardware.utils.interfaces.standardIC;
import com._11robert11.hardware.utils.pin.PinoutParser;
import com._11robert11.hardware.utils.interfaces.Updatable;

import java.util.Arrays;


public class IC74hc00 implements standardIC, Updatable{
    //TODO Testing scalable ideas
    //FIXME ioBuffer has mt 0 index

    boolean[] ioBuffer = new boolean[14]; //Stores data of pins
    PinoutParser pinoutParser;
    public IC74hc00()   {

    }




    @Override
    /***
     * Returns the value of the specified pin
     */
    public boolean getIO(int i) {
        return ioBuffer[i-1];
    }

    @Override
    public boolean[] getIO(int startIndex, int endIndex) {
        return Arrays.copyOfRange(ioBuffer, startIndex, endIndex);
    }

    @Override
    /***
     * set the specified pin to specified boolean
     * @param i Pin to modify
     * @param value new value
     */
    public void setIO(int pin, boolean value) {
        ioBuffer[pin-1] = value;
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

        pin.Y1.value(!(pin.A1.value() & pin.B1.value()));
        pin.Y2.value(!(pin.A2.value() & pin.B2.value()));
        pin.Y3.value(!(pin.A3.value() & pin.B3.value()));
        pin.Y4.value(!(pin.A4.value() & pin.B4.value()));
    }



}
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