package com.example.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestResult {
	private List<Garment> garments;
	@JsonProperty("_embedded")
	private void unpackNameFromNestedObject(Map<String, List<Garment>> result) {
		garments = result.get("garments");
	}
	public List<Garment> getGarments() {
		return garments;
	}
	public void setGarments(List<Garment> garments) {
		this.garments = garments;
	}
	
	
}
