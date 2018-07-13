package com.eprogrammerz.examples.config;

import com.eprogrammerz.examples.exception.ResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.util.*;

public abstract class DynamicResourceLoader {
	
	private final HashMap<String,PropertyParts<URL,byte[],Long>> properties = new HashMap<String,PropertyParts<URL,byte[],Long>>();
	private final Timer t;
	private final Object mutex = new Object();
	private final static Logger logger = LoggerFactory.getLogger(DynamicResourceLoader.class);
	
	public DynamicResourceLoader(int updateFrequency)
	{
		t = new Timer();
		t.scheduleAtFixedRate(new PropertiesUpdateTimer(), 0, updateFrequency);
	}
	
	public void addResource(String location) throws ResourceException
	{
		synchronized(mutex)
		{
			if(!properties.containsKey(location))
			{
				try
				{
					URL resource = new URL("file:" + location);
					File file = new File(resource.getPath());
					if(!file.exists())
					{
						logger.debug("Checking loaded resources for file[" + location + "].");
						resource = this.getClass().getResource(location);
					}
					byte[] content = this.getBytesFromUrl(resource);
					properties.put(location, new PropertyParts<URL,byte[],Long>(resource, content, file.lastModified()));
					this.notifyChange(content);
				}
				catch(IOException ioe)
				{
					throw new ResourceException(ioe);
				}
				
			}
			else
			{
				throw new ResourceException("Properties already loaded for this location[" + location +"].");
			}
		}
		
	}
	
	public void removeResource(String resource) throws ResourceException
	{
		synchronized(mutex)
		{
			this.properties.remove(resource);
		}
	}
	
	public Set<String> getResourceLocations()
	{
		return this.properties.keySet();
	}
	
	public byte[] getByteArray(String resource) throws ResourceException
	{
		byte[] bytes;
		try
		{
			bytes = properties.get(resource).getPartTwo();
		}
		catch(NullPointerException npe)
		{
			throw new ResourceException("File[" + resource + "] is not available, or the resource has been removed.");
		}
		return bytes;
	}
	
	private class PropertiesUpdateTimer extends TimerTask
	{

		@Override
		public void run() {
			synchronized(mutex)
			{
				Iterator<String> it = properties.keySet().iterator();
				while(it.hasNext())
				{
					String key = it.next();
					PropertyParts<URL,byte[],Long> parts = properties.get(key);
					URL url = parts.getPartOne();
					File file = new File(url.getFile());
					Long fileLastModified = file.lastModified();
					Long lastModified = parts.getPartThree();
					if(file.exists() && lastModified < fileLastModified)
					{
						logger.info("File [" + file.getAbsolutePath() + "] has been modified.  Reloading contents.");
						try
						{
							byte[] content = getBytesFromUrl(url);
							parts.setPartTwo(content);
							parts.setPartThree(file.lastModified());
							notifyChange(content);
						}
						catch(IOException ioe)
						{
							logger.error("Properties file[" + file.getAbsolutePath() + " could not be loaded.", ioe);
						}
					}
				}
			}
		}
	}
	private byte[] getBytesFromUrl(URL url) throws IOException
	{
		InputStream is = null;
		try {
			is = new FileInputStream(url.getFile());
			int r = 0;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while((r = is.read()) != -1)
			{
				baos.write(r);
			}
			baos.flush();
			baos.close();
			is.close();
			return baos.toByteArray();
		} finally {
			is.close();
		}

	}
	
	public abstract void notifyChange(byte[] content);
}
