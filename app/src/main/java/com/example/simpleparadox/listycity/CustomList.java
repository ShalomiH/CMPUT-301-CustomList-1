package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * * this function will get the size of list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /* this function will add a city object into the list
    * @param city
    */
    public void addCity(City city){
        cities.add(city);
        return;
    }


    /**
     * This checks if the city belongs in the list
     * @param city
     *      This is the city to check
     * @return
     *      True if city is in the list of cities, otherwise return false
     */
    public boolean hasCity(City city){
        if (cities.contains(city)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This deletes the city from the list of cities
     * @param city
     *      This is the city to delete
     * @throws IllegalArgumentException
     *      Thrown if the user tries to delete a city that does not exists in the list
     */
    public void deleteCity(City city){
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This returns how many cities are in the list
     * @return
     *      Return the number of cities in the list
     */
    public int countCities(){
        return (cities.size());
    }

}
