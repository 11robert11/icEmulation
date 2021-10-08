package com.ic._74hc00;
import com.ic.utils.interfaces.standardIC;
import com.ic.utils.interfaces.Updatable;
import com.ic.utils.pin.PinoutParser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IC74hc00 implements standardIC, Updatable {
    //TODO Testing scalable ideas
    //FIXME ioBuffer has mt 0 index

    boolean[] ioBuffer = new boolean[14]; //Stores data of pins
    Map<String, Integer> pins = new HashMap<>();

    PinoutParser pinoutParser;
    public IC74hc00()   {
        pins.put("A1",  0);
        pins.put("A2",  3);
        pins.put("A3",  8);
        pins.put("A4",  11);

        pins.put("B1",  1);
        pins.put("B2",  4);
        pins.put("B3",  9);
        pins.put("B4",  12);

        pins.put("Y1",  2);
        pins.put("Y2",  5);
        pins.put("Y3",  7);
        pins.put("Y4",  10);

    }
    public void update() {
        //I know, i think this might be faster though, its all about speed
        //TODO Maps might be slower than just putting the number in directly, idk if its worth the crappy code though
        ioBuffer[pins.get("Y1")] = !( ioBuffer[pins.get("A1")] & ioBuffer[pins.get("B1")] );
        ioBuffer[pins.get("Y2")] = !( ioBuffer[pins.get("A2")] & ioBuffer[pins.get("B2")] );
        ioBuffer[pins.get("Y3")] = !( ioBuffer[pins.get("A3")] & ioBuffer[pins.get("B3")] );
        ioBuffer[pins.get("Y4")] = !( ioBuffer[pins.get("A4")] & ioBuffer[pins.get("B4")] );
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
}