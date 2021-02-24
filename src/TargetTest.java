//package com.swe.util;
/**
 * Unit tests for transitivity theory
 * @version 1.0
 */ 
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

@RunWith(Theories.class)
public class TargetTest {
  //if o1.id > o2.id, the compareTo() should return 0 
  //if o1.id < o2.id, the compareTo() should return -1
  //if o1.id = o2.id or o1.val = o2.val, the compareTo() should return 0
  @DataPoints
  public static int [] testValues = {1,3,4,5,6,70,80,100};
  
  //Transitivity theory setup
  @Theory
  public void compareToTestGreater(int i, int j, int k) {
    Target o1 = new Target(i,"first");
    Target o2 = new Target(j,"second");
    Target o3 = new Target(k,"second");
    assumeTrue(o1.compareTo(o2) > 0);  //Assume
    assumeTrue(o2.compareTo(o3) > 0);  //Assume
    assertEquals(o1.compareTo(o2), 1);
    assertEquals(o2.compareTo(o3), 1);
    assertEquals(o1.compareTo(o3), 1);    //Assert
  }
  
  @Theory
  public void compareToTestSmaller(int i, int j, int k){
    Target o1 = new Target(i,"first");
    Target o2 = new Target(j,"second");
    Target o3 = new Target(k,"second");
    
    assumeTrue(o1.compareTo(o2) < 0);
    assumeTrue(o2.compareTo(o3) < 0);
    assertEquals(o1.compareTo(o3), -1);
  }
  
  @Theory
  public void compareToTestEqual(int i, int j, int k){
    Target o1 = new Target(i,"first");
    Target o2 = new Target(j,"second");
    Target o3 = new Target(k,"second");
    
    assumeTrue(o1.compareTo(o2) == 0);
    assumeTrue(o2.compareTo(o3) == 0);
    assertEquals(o1.compareTo(o3), 0);
  }
  
  @Theory
  public void compareToTestCombine1(int i, int j, int k){
    Target o1 = new Target(i,"first");
    Target o2 = new Target(j,"second");
    Target o3 = new Target(k,"second");
    
    assumeTrue(o1.compareTo(o2) == 0);
    assumeTrue(o2.compareTo(o3) > 0);
    assertEquals(o1.compareTo(o3), 1);
  }
  
  @Theory
  public void compareToTestCombine2(int i, int j, int k){
    Target o1 = new Target(i,"first");
    Target o2 = new Target(j,"second");
    Target o3 = new Target(k,"second");
    
    assumeTrue(o1.compareTo(o2) == 0);
    assumeTrue(o2.compareTo(o3) < 0);
    assertEquals(o1.compareTo(o3), -1);
  }
}