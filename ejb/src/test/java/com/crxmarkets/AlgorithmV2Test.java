package com.crxmarkets;

import com.crxmarkets.service.VolumeCalculatorV2;
import com.crxmarkets.service.VolumeCalculatorV2Impl;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

/**
 * Created by Roman on 03.05.2016.
 */
public class AlgorithmV2Test {

  VolumeCalculatorV2 volumeCalculator;

  @Before
  public void before() {
    volumeCalculator = new VolumeCalculatorV2Impl();
  }

  @Test
  public void testNoLeftBorder() {
    assertEquals("Must be 0", 0, (int) volumeCalculator.calculateVolume(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
  }


  @Test
  public void testNoRightBorder() {
    assertEquals("Must be 0", 0, (int) volumeCalculator.calculateVolume(Arrays.asList(7, 6, 5, 4, 3, 2, 1)));
  }

  @Test
  public void testNoUnits() {
    assertEquals("Must be 0", 0, (int) volumeCalculator.calculateVolume(Arrays.asList(1, 1, 1, 1, 1)));
  }

  @Test
  public void testEmptyArray() {
    assertEquals("Must be 0", 0, (int) volumeCalculator.calculateVolume(Collections.EMPTY_LIST));
  }

  @Test
  public void testNullArray() {
    assertEquals("Must be 0", 0, (int) volumeCalculator.calculateVolume(null));
  }

  @Test
  public void testOneUnit() {
    assertEquals("Must be 7", 7, (int) volumeCalculator.calculateVolume(Arrays.asList(9, 2, 9)));
  }

  @Test
  public void testMultipleHills() {
    assertEquals("Must be 9", 9, (int) volumeCalculator.calculateVolume(Arrays.asList(1, 2, 3, 4, 5, 6, 5, 4, 3, 4, 5, 6)));
    assertEquals("Must be 9", 9, (int) volumeCalculator.calculateVolume(Arrays.asList(6, 5, 4, 3, 4, 5, 6, 5, 4, 3, 2, 1)));
    assertEquals("Must be 0", 1, (int) volumeCalculator.calculateVolume(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 3)));
    assertEquals("Must be 0", 1, (int) volumeCalculator.calculateVolume(Arrays.asList(3, 2, 3, 4, 5, 6, 7, 8, 9)));
  }

  @Test
  public void testLargeCount() {
    int size = 1000000;
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < size; i++) {
      list.add((int) Math.round(Math.random() * 100));
    }
    assertNotSame("Must be not 0", 0, volumeCalculator.calculateVolume(list));
  }

}
