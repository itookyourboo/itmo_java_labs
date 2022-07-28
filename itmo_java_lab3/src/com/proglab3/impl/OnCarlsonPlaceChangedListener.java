package com.proglab3.impl;

import com.proglab3.entity.Carlson;
import com.proglab3.place.Place;

public interface OnCarlsonPlaceChangedListener {
    void onCarlsonPlaceChanged(Carlson carlson, Place place);
}
