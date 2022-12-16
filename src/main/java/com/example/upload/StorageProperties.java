package com.example.upload;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage")
public class StorageProperties {

	private String location="upload-dir";
	
	public String getLocation() {
		return location;
	}
	public void setLocation() {
		this.location=location;
	}
}
