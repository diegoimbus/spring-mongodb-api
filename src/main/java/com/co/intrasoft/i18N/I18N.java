package com.co.intrasoft.i18N;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
/**
 * Internationalization class
 * 
 * @author Diego Imbus <dsn.imbus01@gmail.com>
 */
public class I18N {

	/**
	 * Determine the current locale based on the session cookies
	 * 
	 * @return Returns a Locale
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}
	
	/**
	 * Method to get the source properties file of the Strings
	 * to work with
	 * 
	 * @return Returns reference to the properties file
	 */
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
		rs.setBasename("messages");
		rs.setUseCodeAsDefaultMessage(true);
		return rs;
	}
	
}
