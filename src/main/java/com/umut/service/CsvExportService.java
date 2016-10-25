package com.umut.service;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.umut.exception.CsvExportException;
import com.umut.service.model.CsvItem;

public class CsvExportService {
	private static final Logger logger = LoggerFactory
			.getLogger(CsvExportService.class);
	private static final String NEW_LINE_SEPARATOR = "\n";

	private static final Object[] FILE_HEADER = { "_id", "name", "type",
			"latitude", "longitude" };

	public void exportResults(List<CsvItem> csvItems, String fileName) throws CsvExportException {

		CSVFormat csvFileFormat = CSVFormat.DEFAULT
				.withRecordSeparator(NEW_LINE_SEPARATOR);

		try (FileWriter fileWriter = new FileWriter(fileName);
				CSVPrinter csvFilePrinter = new CSVPrinter(fileWriter,
						csvFileFormat)) {

			csvFilePrinter.printRecord(FILE_HEADER);
			for (CsvItem csvItem : csvItems) {
				List<String> record = new ArrayList<>();
				record.add(csvItem.getId().toString());
				record.add(csvItem.getName());
				record.add(csvItem.getType());
				record.add(csvItem.getLatitude().toString());
				record.add(csvItem.getLongitude().toString());
				csvFilePrinter.printRecord(record);
			}
			logger.debug("CSV file was created successfully...");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CsvExportException();
		}

	}

}
