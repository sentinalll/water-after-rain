package com.crxmarkets.service;


import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;


@Stateless
public class VolumeCalculatorImpl implements VolumeCalculator {

  private static final Logger LOGGER = LogManager.getLogger(VolumeCalculatorImpl.class);

  public Integer calculateVolume(List<Integer> surface) {
    LOGGER.debug("calculateVolume method started");
    if (LOGGER.isTraceEnabled()) {
      LOGGER.trace("with surface: " + surface);
    }
    if (surface == null || surface.isEmpty()) {
      LOGGER.debug("calculateVolume method end with result: 0");
      return 0;
    }
    int i = 0;
    int j = surface.size() - 1;
    int count = 0;
    while (i < j) {
      int minBorder;
      boolean fromLeft;
      if (surface.get(i) < surface.get(j)) {
        minBorder = surface.get(i);
        fromLeft = true;
      } else {
        minBorder = surface.get(j);
        fromLeft = false;
      }

      if (fromLeft) {
        while (i < j) {
          if (surface.get(i) <= minBorder) {
            count += minBorder - surface.get(i);
            i++;
          } else {
            break;
          }
        }
      } else {
        while (i < j) {
          if (surface.get(j) <= minBorder) {
            count += minBorder - surface.get(j);
            j--;
          } else {
            break;
          }
        }
      }
    }
    LOGGER.debug("calculateVolume method end with result: " + count);
    return count;
  }
}
