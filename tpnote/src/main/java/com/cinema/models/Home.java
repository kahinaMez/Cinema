package com.cinema.models;

import java.util.List;

public class Home {
	
	private List<String> urls;
	private static int counter = 1;
	
	public Home(List<String> urls) {
		super();
		this.urls = urls;
	}
	
	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
	
	public String getNextUrl() {
		
		if(counter == urls.size())
			counter=0;
		System.out.println(counter);
		
		String url = urls.get(counter);
		
		counter ++;
		
		return url;		
	}
	
}
