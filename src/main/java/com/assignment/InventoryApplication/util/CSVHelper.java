package com.assignment.InventoryApplication.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.assignment.InventoryApplication.model.InventoryDetails;


@Component
public class CSVHelper {

	private static Logger log = LogManager.getLogger(CSVHelper.class);
	public static String type = "text/csv";
	static String[] headers = { "code", "name", "batch", "stock", "deal", "free", "mrp", "rate", "exp", "company",
			"supplier" };
	static SimpleDateFormat date_format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

	public static boolean hasCSVFormat(MultipartFile file) {
		if (type.equals(file.getContentType()) || file.getContentType().equals("application/vnd.ms-excel")) {
			log.info("uploaded csv file");
			return true;
		}
		log.error("not uploaded csv file");
		return false;
	}

	public static List<InventoryDetails> csvToList(InputStream is) throws NumberFormatException, ParseException {
		try {
			log.info("convert csv file to list");
			BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			CSVParser csvParser = new CSVParser(fileReader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			List<InventoryDetails> details = getcsvToList(csvParser);
			log.info("converted csv file to list");
			return details;
		} catch (IOException e) {
			log.error("fail to parse csv file");
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

	public static List<InventoryDetails> getcsvToList(CSVParser csvParser) {
		List<InventoryDetails> details = new ArrayList<InventoryDetails>();
		try {
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			Date date;
			for (CSVRecord csvRecord : csvRecords) {
				date = csvRecord.get("exp").matches("\\d{2}-\\d{2}-\\d{4}") ? date_format.parse(csvRecord.get("exp"))
						: null;
				InventoryDetails inventoryDetails = new InventoryDetails(csvRecord.get("code"), csvRecord.get("name"),
						csvRecord.get("batch"), Integer.parseInt(csvRecord.get("stock")),
						Integer.parseInt(csvRecord.get("deal")), Integer.parseInt(csvRecord.get("free")),
						Double.parseDouble(csvRecord.get("mrp")), Double.parseDouble(csvRecord.get("rate")), date,
						csvRecord.get("company"), csvRecord.get("supplier"));
				details.add(inventoryDetails);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return details;
	}

}
