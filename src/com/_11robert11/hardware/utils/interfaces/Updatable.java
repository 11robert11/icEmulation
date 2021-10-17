package com._11robert11.hardware.utils.interfaces;


/***
 * Implents the method used to update a circuts logic
 */
public interface Updatable {
    void updatePins();
    void updateIoBuffer();
    void updateLogic() throws ClassNotFoundException;
}
