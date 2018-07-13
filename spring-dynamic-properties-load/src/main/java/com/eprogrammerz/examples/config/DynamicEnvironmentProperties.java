package com.eprogrammerz.examples.config;

import com.eprogrammerz.examples.exception.ResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.Enumeration;
import java.util.Properties;

@Component
public class DynamicEnvironmentProperties extends DynamicResourceLoader {

	private final static Logger logger = LoggerFactory.getLogger(DynamicEnvironmentProperties.class);
	private final static Object mutex = new Object();
	public DynamicEnvironmentProperties() {
		super(30000);  //set update frequency each 30 sec
	}
	
	public void loadProperties(String location) throws ResourceException
	{
		this.addResource(location);
	}

	public void resourceChange(byte[] resource) {
		ByteArrayInputStream bais = new ByteArrayInputStream(resource);
		Properties props = new Properties();
		try
		{
			props.load(bais);
		}
		catch(Exception e)
		{
			//do nothing
		}
		Enumeration en = props.keys();
		while(en.hasMoreElements())
		{
			String key = (String)en.nextElement();
			System.setProperty(key, props.getProperty(key));
		}	
	}

	@Override
	public void notifyChange(byte[] content) {
		this.resourceChange(content);		
	}
}
