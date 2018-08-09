/*
 * 
 * Copyright (c) 2018 Solace Corp.
 * 
 */
package org.springframework.cloud.stream.app.converter.processor;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for the Converter Processor module.
 * Determines whether conversion should be to Celsius or Fahrenheit.
 *
 * @author Solace Corp.
 */
@ConfigurationProperties("converter")
public class ConverterProcessorProperties {
	private boolean convertToCelsius = true;

	public void setConvertToCelsius(boolean convertToCelsius) {
		this.convertToCelsius = convertToCelsius;
	}

	public boolean getConvertToCelsius() {
		return convertToCelsius;
	}
}
