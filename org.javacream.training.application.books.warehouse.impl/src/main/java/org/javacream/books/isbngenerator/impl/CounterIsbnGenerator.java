package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;

public class CounterIsbnGenerator implements IsbnGenerator {

	private String _prefix;
	private String countryCode;
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}
	private int counter;
	public String next(){
		return _prefix + counter++ + countryCode;
	}

	public String getPrefix(){
		return _prefix;
	}
	public void setPrefiX(String prefix) {
		this._prefix = prefix;
	}
}
