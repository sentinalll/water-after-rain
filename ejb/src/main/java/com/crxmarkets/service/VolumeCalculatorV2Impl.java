package com.crxmarkets.service;

import java.util.List;

import javax.ejb.Stateless;

/**
 * Created by Roman Sydorov
 */
@Stateless
public class VolumeCalculatorV2Impl implements VolumeCalculatorV2 {
  public Integer calculateVolume(List<Integer> surface) {
    if (surface == null || surface.isEmpty()) {
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
    return count;
  }
}
