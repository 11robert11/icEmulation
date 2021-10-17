package com._11robert11.hardware.memory.utils;

import java.util.BitSet;

public class Utils {
    public static BitSet byteToBitSet(byte b) {
        BitSet bs = new BitSet();
        for (int i = 0; i < Byte.SIZE; i++) {
            if (((b >> i) & 1) == 1) {
                bs.set(i);

            }
        }
        return bs;
    }
    public static boolean[] bitSetToBooleans(BitSet bs)   {
        boolean[] booleans = new boolean[bs.size()];
        for (int i = 0; i < bs.length(); i++) {
            booleans[i] = bs.get(i);
        }
        return booleans;
    }
}
