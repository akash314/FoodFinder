package com.findmefood.controllers;

import com.findmefood.googleplace.FoodPlaceFinder;
import com.findmefood.googleplace.GooglePlaceFinder;
import com.findmefood.model.RestaurantDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FindPlaces {

    private final GooglePlaceFinder googlePlaceFinder;

    private final FoodPlaceFinder foodPlaceFinder;

    @Autowired
    public FindPlaces(GooglePlaceFinder googlePlaceFinder, FoodPlaceFinder foodPlaceFinder) {
        this.googlePlaceFinder = googlePlaceFinder;
        this.foodPlaceFinder = foodPlaceFinder;
    }

    @RequestMapping("/foodplaces")
    public List<RestaurantDetails> greeting(@RequestParam(value="name", defaultValue="Restaurant") String name,
                                            @RequestParam(value="lat", defaultValue="42.3385905") String lat,
                                            @RequestParam (value="lat", defaultValue="-71.0920237") String lon) throws IOException {
        //return googlePlaceFinder.getResults(name, lat+","+lon);
        return foodPlaceFinder.getResults(name, lat, lon);
    }
}
