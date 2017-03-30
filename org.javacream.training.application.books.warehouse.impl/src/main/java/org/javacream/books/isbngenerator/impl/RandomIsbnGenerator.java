package org.javacream.books.isbngenerator.impl;

import java.util.Random;

import org.javacream.books.isbngenerator.api.IsbnGenerator;

public class RandomIsbnGenerator implements IsbnGenerator {

	private String _prefix;
	private String countryCode;
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String suffix) {
		this.countryCode = suffix;
	}
	private Random random;
	
	{
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}
	
	public void initThekeyGenerator(){
		System.out.println("initializing " + this);
	}
	public void destroyThekeyGenerator(){
		System.out.println("destroying " + this);
	}
	
	/* (non-Javadoc)
	 * @see org.javacream.keygeneration.business.KeyGenerator#next()
	 */
	public String next(){
		return _prefix + random.nextInt() + countryCode;
	}

	public String getPrefix(){
		return _prefix;
	}
	public void setPrefiX(String prefix) {
		this._prefix = prefix;
	}
}
