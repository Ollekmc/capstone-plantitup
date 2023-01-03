package de.capstone.backend.model;

public class Scale {

    public Scale(int scale)
    {
        if(scale>=10 || scale<0)
        {
            throw new IllegalArgumentException("Scale should be in the range of [0-10].");
        }
    }
}
