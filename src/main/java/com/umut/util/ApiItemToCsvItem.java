package com.umut.util;

import java.util.ArrayList;
import java.util.List;

import com.umut.service.model.CsvItem;
import com.umut.service.model.Location;

public class ApiItemToCsvItem {

	private ApiItemToCsvItem() {
	}

	public static List<CsvItem> convert(List<Location> items) {
		List<CsvItem> csvItems = new ArrayList<>();
		for (Location item : items) {
			if (null != item.getGeoPosition()) {
				CsvItem csvItem = new CsvItem();
				csvItem.setId(item.getId());
				csvItem.setLatitude(item.getGeoPosition().getLatitude());
				csvItem.setLongitude(item.getGeoPosition().getLongitude());
				csvItem.setName(item.getName());
				csvItem.setType(item.getType());
				csvItems.add(csvItem);
			}
		}
		return csvItems;
	}
}
