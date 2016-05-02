package com.crxmarketx.task.algorithm;

import com.crxmarketx.task.pojo.Gap;

import javax.ejb.Stateless;

/**
 * Created by Roman on 03.05.2016.
 */
@Stateless
public class VolumeOfWaterFinderImpl implements VolumeOfWaterFinder {
    public Integer calculateVolume(int[] array) {
        int countOfWater = 0;
        boolean fillGaps = true;
        Gap gap = null;
        while (fillGaps) {
            boolean isAtLeastOneGap = false;
            while ((gap = findNextAfter(gap, array)) != null) {
                isAtLeastOneGap = true;
                int minBorder = Math.min(gap.getWidthLeft(), gap.getWidthRight());
                for (int i = gap.getLeftBorder() + 1; i < gap.getRightBorder(); i++) {
                    countOfWater += minBorder - array[i];
                    array[i] = minBorder;
                }
            }
            fillGaps = isAtLeastOneGap;
        }
        return countOfWater;
    }

    private Gap findNextAfter(Gap previous, int[] array) {
        int from = 0;
        if (previous != null) {
            from = previous.getRightBorder();
            if (checkEndOfArray(array, from + 1)) {
                return null;
            }
        }
        if (from - 1 < 0) {
            int i = from + 1;
            while (array[i] >= array[i - 1]) {
                i++;
                if (checkEndOfArray(array, i)) {
                    return null;
                }
            }
            from = i - 1;
        }

        int i = from + 1;
        while (array[i] <= array[i - 1]) {
            i++;
            if (checkEndOfArray(array, i)) {
                return null;
            }
        }
        int to = i;
        Gap g = new Gap();
        g.setLeftBorder(from);
        g.setRightBorder(to);
        g.setWidthLeft(array[from]);
        g.setWidthRight(array[to]);
        return g;
    }

    private boolean checkEndOfArray(int[] array, int i) {
        return i >= array.length;
    }
}
