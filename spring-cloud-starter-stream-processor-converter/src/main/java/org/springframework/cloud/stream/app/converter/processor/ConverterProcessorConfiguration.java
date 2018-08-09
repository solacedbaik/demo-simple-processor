/*
 * 
 * Copyright (c) 2018 Solace Corp.
 * 
 */
package org.springframework.cloud.stream.app.converter.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;


/**
 * A temperature units conversion processor (Metric / Imperial)
 *
 * @author Solace Corp
 */
@EnableBinding(Processor.class)
@EnableConfigurationProperties(ConverterProcessorProperties.class)
public class ConverterProcessorConfiguration {
	@Autowired
	private ConverterProcessorProperties properties;
	
	// Imperative (procedural) style
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Double doConversion(Double temperature) {
		if (properties.getConvertToCelsius())
			return ((temperature - 32) * 5 / 9);
		else
			return (temperature * 9 / 5 + 32);
    }
}
