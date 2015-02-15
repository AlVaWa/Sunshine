package com.waageweb.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        JSONObject weatherObject = new JSONObject(weatherJsonStr);
        JSONArray list = weatherObject.getJSONArray("list");
        JSONObject day = (JSONObject) list.get(dayIndex);
        JSONObject temp = day.getJSONObject("temp");
        double maxTemp = temp.getDouble("max");
        return maxTemp;
    }

}