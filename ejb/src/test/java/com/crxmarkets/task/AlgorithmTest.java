package com.crxmarkets.task;

import com.crxmarkets.task.algorithm.VolumeOfWaterFinder;
import com.crxmarkets.task.algorithm.VolumeOfWaterFinderImpl;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

/**
 * Created by Roman on 03.05.2016.
 */
public class AlgorithmTest {

    VolumeOfWaterFinder volumeOfWaterFinder;

    @Before
    public void before() {
        volumeOfWaterFinder = new VolumeOfWaterFinderImpl();
    }

    @Test
    public void testNoLeftBorder() {
        int[] testArr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int res = volumeOfWaterFinder.calculateVolume(testArr);
        assertEquals("Must be 0", 0, res);
    }

    @Test
    public void testRelief3() {
        int[] testArr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 3};
        int res = volumeOfWaterFinder.calculateVolume(testArr);
        assertEquals("Must be 0", 1, res);
    }

    @Test
    public void testRelief4() {
        int[] testArr = new int[]{3, 2, 3, 4, 5, 6, 7, 8, 9};
        int res = volumeOfWaterFinder.calculateVolume(testArr);
        assertEquals("Must be 0", 1, res);
    }

    @Test
    public void testNoRightBorder() {
        int[] testArr = new int[]{7, 6, 5, 4, 3, 2, 1};
        int res = volumeOfWaterFinder.calculateVolume(testArr);
        assertEquals("Must be 0", 0, res);
    }

    @Test
    public void testNoUnits() {
        int[] testArr = new int[]{1, 1, 1, 1, 1};
        int res = volumeOfWaterFinder.calculateVolume(testArr);
        assertEquals("Must be 0", 0, res);
    }

    @Test
    public void testEmptyArray() {
        int[] testArr = new int[0];
        int res = volumeOfWaterFinder.calculateVolume(testArr);
        assertEquals("Must be 0", 0, res);
    }

    @Test
    public void testOneUnit() {
        int[] testArr = new int[]{9, 2, 9};
        int res = volumeOfWaterFinder.calculateVolume(testArr);
        assertEquals("Must be 7", 7, res);
    }

    @Test
    public void testMultipleUnits() {
        int[] testArr = new int[]{9, 2, 9, 0, 4};
        int res = volumeOfWaterFinder.calculateVolume(testArr);
        assertEquals("Must be 11", 11, res);
    }

    @Test
    public void testRelief1() {
        int[] testArr = new int[]{1, 2, 3, 4, 5, 6, 5, 4, 3, 4, 5, 6};
        int res = volumeOfWaterFinder.calculateVolume(testArr);
        assertEquals("Must be 9", 9, res);
    }

    @Test
    public void testRelief2() {
        int[] testArr = new int[]{6, 5, 4, 3, 4, 5, 6, 5, 4, 3, 2, 1};
        int res = volumeOfWaterFinder.calculateVolume(testArr);
        assertEquals("Must be 9", 9, res);
    }

    @Test
    public void testLargeCount() {
        int size = 32000;
        int[] testArr = new int[size];
        for (int i = 0; i < size; i++) {
            testArr[i] = Integer.parseInt(String.valueOf(Math.round(Math.random() * 100)));
        }
        int res = volumeOfWaterFinder.calculateVolume(testArr);
        assertNotSame("Must be not 0", 0, res);
    }

}
