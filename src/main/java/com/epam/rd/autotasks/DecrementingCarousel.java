package com.epam.rd.autotasks;

import java.util.ArrayList;

public class DecrementingCarousel {
    private final int capacity;
    static int[] carousel;
    int index;
    boolean isRun;

    {
        index = 0;
        isRun = false;
    }

    public DecrementingCarousel(int capacity) {
        this.capacity = capacity;
        carousel = new int[capacity];

    }

    public boolean addElement(int element){

        if (element > 0 && index < capacity && !isRun) {
            carousel[index++] = element;
            return true;
        }
        return false;
        //throw new UnsupportedOperationException();
    }

    public CarouselRun run(){
        if (!isRun) {
            isRun = true;
            return new CarouselRun();
        }
        return null;
        //throw new UnsupportedOperationException();
    }
}
