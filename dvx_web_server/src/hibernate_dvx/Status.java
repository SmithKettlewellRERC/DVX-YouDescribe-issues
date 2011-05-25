package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Status entity. @author MyEclipse Persistence Tools
 */
public class Status extends AbstractStatus implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Status() {
	}

	/** full constructor */
	public Status(String statusDescription, Timestamp created, Timestamp modified,
			Set movies) {
		super(statusDescription, created, modified, movies);
	}

}
