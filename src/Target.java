//package com.swe.util;
/**
 * Base class for theory testing 
 * @version 1.0
 */
public class Target implements Comparable<Target>{
    int id;
    public String val;

    public Target(int id, String val) {
        this.id = id;
        this.val = val;
    }

    public int compareTo(Target that){
        if(this.id > that.id)
            return 1;
        if(this.id < that.id)
            return -1;
        if(this.val == that.val || this.id == that.id)
            return 0;
        return 0;
    }
}


