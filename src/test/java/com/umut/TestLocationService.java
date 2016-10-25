package com.umut;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.umut.exception.ApiException;
import com.umut.service.LocationService;
import com.umut.service.model.Location;

public class TestLocationService {
	
	@Test
	public void testApi() throws ApiException{
		LocationService locationService = new LocationService();
		List<Location> locations = locationService.getLocations("BERLIN");
		Assert.assertTrue(locations.size() > 0);
	}
	
	@Test
	public void testConvertion() throws ApiException, IOException{
		LocationService locationService = new LocationService();
		List<Location> locations = locationService.convertJSONToList(readFile());
		Assert.assertTrue(locations.size() == 1);
		Assert.assertEquals(locations.get(0).getName(), "Berlin");
		Assert.assertEquals("Wrong latitude", locations.get(0).getGeoPosition().getLatitude(), 52.52437d, 0);
		Assert.assertEquals("Wrong longitude", locations.get(0).getGeoPosition().getLongitude(), 13.41053d, 0);
	}
	
	private String readFile() throws IOException {
		return IOUtils.toString(this.getClass().getResourceAsStream("/locations.json"), "UTF-8");
	}
}
