package hibernate_dvx;

import java.sql.Timestamp;

/**
 * Description entity. @author MyEclipse Persistence Tools
 */
public class Description extends AbstractDescription implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Description() {
	}

	/** full constructor */
	public Description(Movie movie, Author author, String descriptionLong,
			String descriptionShort, Timestamp created, Timestamp modified) {
		super(movie, author, descriptionLong, descriptionShort, created,
				modified);
	}

}
