package hibernate_dvx;

import java.sql.Timestamp;

/**
 * Language entity. @author MyEclipse Persistence Tools
 */
public class Language extends AbstractLanguage implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Language() {
	}

	/** full constructor */
	public Language(String languageName, String languageNameShort,
			Timestamp created, Timestamp modified) {
		super(languageName, languageNameShort, created, modified);
	}

}
