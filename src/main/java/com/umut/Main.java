package com.umut;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.umut.exception.ApiException;
import com.umut.exception.CsvExportException;
import com.umut.service.CsvExportService;
import com.umut.service.LocationService;
import com.umut.service.model.CsvItem;
import com.umut.service.model.Location;
import com.umut.util.ApiItemToCsvItem;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		if(args.length != 1){
			logger.error("Please send city as paramater");
			System.exit(1);
		}
		Main main = new Main();
		main.exportToCsv(args[0]);
	}

	private void exportToCsv(String city) {
		LocationService locationService = new LocationService();
		CsvExportService csvExportService = new CsvExportService();
		try {
			List<Location> locationItems = locationService.getLocations(city);
			List<CsvItem> csvItems = ApiItemToCsvItem.convert(locationItems);
			String fileName = "EXPORT_" + city + ".csv";
			csvExportService.exportResults(csvItems, fileName);
			logger.info("Program has finished successfully, you could find your response on file " + fileName);
		} catch (ApiException e) {
			logger.error(e.getMessage(), e);
			System.exit(2);
		} catch (CsvExportException e) {
			logger.error(e.getMessage(), e);
			System.exit(3);
		}
		
	}

}
