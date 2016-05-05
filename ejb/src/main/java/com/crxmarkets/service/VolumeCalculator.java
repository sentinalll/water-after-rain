package com.crxmarkets.service;

import java.util.List;

import javax.ejb.Local;

/**
 * Created by Roman on 03.05.2016.
 */
@Local
public interface VolumeCalculator {

    Integer calculateVolume(List<Integer> surface);
}


