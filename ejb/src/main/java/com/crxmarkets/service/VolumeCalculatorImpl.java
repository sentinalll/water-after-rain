package com.crxmarkets.service;

import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class VolumeCalculatorImpl implements VolumeCalculator {
  private static final Logger LOGGER = Logger.getLogger(VolumeCalculatorImpl.class);

  public Integer calculateVolume(List<Integer> surface) {
    LOGGER.debug("calculateVolume method started with array:" + surface);
    if (surface == null || surface.isEmpty()) {
      return 0;
    }
    List<Integer> temp = new ArrayList<Integer>(surface);

    int countOfWater = 0;
    boolean isUnitsToFill = true;

    Unit unit = null;

    while (isUnitsToFill) {

      boolean isAtLeastOneUnit = false;
      while ((unit = findNextAfter(unit, temp)) != null) {
        isAtLeastOneUnit = true;
        countOfWater += fillUnitWithWater(unit, temp);
      }
      isUnitsToFill = isAtLeastOneUnit;
    }
    LOGGER.debug("calculateVolume method ended with result:" + countOfWater);

    return countOfWater;
  }

  private int fillUnitWithWater(Unit unit, List<Integer> surface) {
    LOGGER.debug("fillUnitWithWater method started with unit: " + unit);
    int count = 0;
    int minBorder = Math.min(unit.getWidthLeft(), unit.getWidthRight());
    for (int i = unit.getLeftBorder() + 1; i < unit.getRightBorder(); i++) {
      if (surface.get(i) < minBorder) {
        count += minBorder - surface.get(i);
        surface.set(i, minBorder);
      }
    }
    LOGGER.debug("fillUnitWithWater method ended with count of filled water: " + count);
    return count;
  }

  private Unit findNextAfter(Unit previous, List<Integer> surface) {
    LOGGER.debug("findNextAfter method started with Unit: " + previous);
    int leftBorder = 0;
    if (previous != null) {
      leftBorder = previous.getRightBorder();
      if (isEndOfSurface(surface, leftBorder + 1)) {
        LOGGER.debug("Unit after previous: " + previous + " not found");
        LOGGER.debug("findNextAfter method ended");
        return null;
      }
    }
    int i = leftBorder + 1;
    while (surface.get(i) >= surface.get(i - 1)) {
      i++;
      if (isEndOfSurface(surface, i)) {
        LOGGER.debug("Unit after previous: " + previous + " not found");
        LOGGER.debug("findNextAfter method ended");
        return null;
      }

    }
    leftBorder = i - 1;

    while (surface.get(i) <= surface.get(i - 1)) {
      i++;
      if (isEndOfSurface(surface, i)) {
        LOGGER.debug("Unit after previous: " + previous + " not found");
        LOGGER.debug("findNextAfter method ended");
        return null;
      }
    }
    int rightBorder = i;
    Unit unit = new Unit(leftBorder, rightBorder, surface.get(leftBorder), surface.get(rightBorder));
    LOGGER.debug("findNextAfter method ended with find unit: " + unit);
    return unit;
  }


  private boolean isEndOfSurface(List<Integer> surface, Integer i) {
    return i >= surface.size();
  }
}
