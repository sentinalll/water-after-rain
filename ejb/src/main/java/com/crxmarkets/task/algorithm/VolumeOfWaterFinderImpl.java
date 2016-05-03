package com.crxmarkets.task.algorithm;

import com.crxmarkets.task.pojo.Unit;
import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import java.util.Arrays;

/**
 * Created by Roman on 03.05.2016.
 */
@Stateless
public class VolumeOfWaterFinderImpl implements VolumeOfWaterFinder {
    private static final Logger LOGGER = Logger.getLogger(VolumeOfWaterFinderImpl.class);

    public Integer calculateVolume(int[] src) {
        LOGGER.debug("calculateVolume method started with array:" + Arrays.toString(src));
        if (src.length == 0) {
            return 0;
        }
        int[] array = new int[src.length];
        System.arraycopy(src, 0, array, 0, src.length);
        int countOfWater = 0;
        boolean fillUnits = true;
        Unit unit = null;

        while (fillUnits) {
            boolean isAtLeastOneUnit = false;
            while ((unit = findNextAfter(unit, array)) != null) {
                isAtLeastOneUnit = true;
                countOfWater += fillUnitsWithWater(array, unit);
            }
            fillUnits = isAtLeastOneUnit;
        }
        LOGGER.debug("calculateVolume method ended with result:" + countOfWater);
        return countOfWater;
    }

    private int fillUnitsWithWater(int[] array, Unit unit) {
        LOGGER.debug("fillUnitsWithWater method started with unit: " + unit);
        int count = 0;
        int minBorder = Math.min(unit.getWidthLeft(), unit.getWidthRight());
        for (int i = unit.getLeftBorder() + 1; i < unit.getRightBorder(); i++) {
            count += minBorder - array[i];
            array[i] = minBorder;
        }
        LOGGER.debug("fillUnitsWithWater method ended with count of filled water: " + count);
        return count;
    }

    private Unit findNextAfter(Unit previous, int[] surface) {
        LOGGER.debug("findNextAfter method started with Unit: " + previous);
        int from = 0;
        if (previous != null) {
            from = previous.getRightBorder();
            if (isEndOfSurface(surface, from + 1)) {
                LOGGER.debug("Unit after previous: " + previous + " not found");
                LOGGER.debug("findNextAfter method ended");
                return null;
            }
        }
        if (from == 0) {
            int i = from + 1;
            while (surface[i] >= surface[i - 1]) {
                i++;
                if (isEndOfSurface(surface, i)) {
                    LOGGER.debug("Unit after previous: " + previous + " not found");
                    LOGGER.debug("findNextAfter method ended");
                    return null;
                }
            }
            from = i - 1;
        }

        int i = from + 1;
        while (surface[i] <= surface[i - 1]) {
            i++;
            if (isEndOfSurface(surface, i)) {
                LOGGER.debug("Unit after previous: " + previous + " not found");
                LOGGER.debug("findNextAfter method ended");
                return null;
            }
        }
        int to = i;
        Unit unit = new Unit(from, to, surface[from], surface[to]);
        LOGGER.debug("findNextAfter method ended with find unit: " + unit);
        return unit;
    }

    private boolean isEndOfSurface(int[] array, int i) {
        return i >= array.length;
    }
}
