package hibernate_dvx;

import java.sql.Timestamp;

/**
 * AbstractLanguage entity provides the base persistence definition of the
 * Language entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLanguage extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer languageId;
	private String languageName;
	private String languageNameShort;
	private Timestamp created;
	private Timestamp modified;

	// Constructors

	/** default constructor */
	public AbstractLanguage() {
	}

	/** full constructor */
	public AbstractLanguage(String languageName, String languageNameShort,
			Timestamp created, Timestamp modified) {
		this.languageName = languageName;
		this.languageNameShort = languageNameShort;
		this.created = created;
		this.modified = modified;
	}

	// Property accessors

	public Integer getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return this.languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getLanguageNameShort() {
		return this.languageNameShort;
	}

	public void setLanguageNameShort(String languageNameShort) {
		this.languageNameShort = languageNameShort;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

}