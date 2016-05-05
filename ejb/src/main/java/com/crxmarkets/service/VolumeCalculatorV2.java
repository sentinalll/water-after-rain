package com.crxmarkets.service;

import java.util.List;

import javax.ejb.Local;

/**
 * Created by Roman Sydorov
 */
@Local
public interface VolumeCalculatorV2 {

  Integer calculateVolume(List<Integer> surface);
}
