package com.umut.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.umut.exception.ApiException;
import com.umut.service.model.Location;

public class LocationService {
	private static final Logger logger = LoggerFactory
			.getLogger(LocationService.class);
	private static String BASE_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

	public List<Location> getLocations(String city) throws ApiException {
		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
			HttpGet request = new HttpGet(BASE_URL + city);
			request.addHeader("Content-Type",
					ContentType.APPLICATION_JSON.getMimeType());
			HttpResponse response = client.execute(request);
			String content = IOUtils
					.toString(response.getEntity().getContent());
			return convertJSONToList(content);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new ApiException(e.getMessage());
		}
	}

	public List<Location> convertJSONToList(String content) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(content, new TypeToken<ArrayList<Location>>() {
		}.getType());
	}

}
