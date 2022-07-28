package com.proglab4.impl;

import com.proglab4.entity.Carlson;
import com.proglab4.place.Place;

public interface OnCarlsonPlaceChangedListener {
    void onCarlsonPlaceChanged(Carlson carlson, Place place);
}
