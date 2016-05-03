package com.crxmarkets.task.algorithm;

import javax.ejb.Local;

/**
 * Created by Roman on 03.05.2016.
 */
@Local
public interface VolumeOfWaterFinder {

    Integer calculateVolume(int[] array);
}


