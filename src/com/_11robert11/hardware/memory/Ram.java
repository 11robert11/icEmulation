package com._11robert11.hardware.memory;



import java.io.*;


public class Ram {
    //TODO make Ram class work with multiple rom formats, idealy with a header in the rom file
    //TODO this should not be called ram
    //TODO WIP not finished, don't have the docs ot do it
    RandomAccessFile mem;
    int WORD_COUNT = 32768;
    int WORD_LEN = 8;
    int header = 0;    //Bytes
    //WORD_COUNT and WORD_LEN need to be varible because the Ram class needs to support diffrent data schemes

    public Ram(RandomAccessFile mem) throws IOException {
        this.mem = mem;
    }
    public boolean[] readWord(int wordIndex) throws IOException {
        boolean[] word = new boolean[WORD_LEN];
        for (int i = 0; i < WORD_LEN; i++, wordIndex++) {
            word[i] = read(wordIndex);
        }
        return word;
    }
    public void writeWord(int wordIndex, boolean[] word) throws IOException {
        for (int i = 0; i < WORD_LEN; i++, wordIndex++) {
            write(wordIndex, word[i]);
        }
    }
    public boolean read(int bitIndex) throws IOException {

        //TODO maybe make this stuff into its own method, it is going to occur multiple time.
        int byteIndexInData = bitIndex / WORD_LEN;  //What byte in out data conatins the bit in question
        int bitIndexInByte = (bitIndex % WORD_LEN);
        dataSeek(byteIndexInData);
        byte myByte = mem.readByte();
        return (myByte >> bitIndexInByte & 1) == 1;
    }

    public void write(int bitIndex, boolean value) throws IOException {
        int byteIndexInData = bitIndex / WORD_LEN;  //What byte in out data conatins the bit in question
        int bitIndexInByte = (bitIndex % WORD_LEN);

        dataSeek(byteIndexInData);


        byte myByte = mem.readByte();
        if(value)
            myByte |= 1 << bitIndexInByte;
        else
            myByte &= ~(1 << bitIndexInByte);



        dataSeek(byteIndexInData);

        mem.writeByte(myByte);

    }

    public int getWordCount()   {
        return WORD_COUNT;
    }

    public int getWordLen() {
        return WORD_LEN;
    }

    private void dataSeek(long pos) throws IOException {
        mem.seek(pos + header);
    }

}
