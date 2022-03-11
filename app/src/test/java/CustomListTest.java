import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    // Needs to be initialized so that the test does not return null values.
    @Before
    public void createList(){
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(listSize+1, list.getCount());
    }




    @Test
    public void hasCityTest(){
        City city = new City("Halifax", "NS");
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /*
    @Test
    public void deleteCityTest(){
        // placeholder
    }

    @Test
    public void countCitiesTest(){
        // placeholder
    }
*/
}
