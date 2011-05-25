package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Set;

/**
 * UserDetail entity. @author MyEclipse Persistence Tools
 */
public class UserDetail extends AbstractUserDetail implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public UserDetail() {
	}

	/** minimal constructor */
	public UserDetail(User user) {
		super(user);
	}

	/** full constructor */
	public UserDetail(User user, State state, ZipCode zipCode, City city,
			Country country, String userDetailFirstName,
			String userDetailLastName, String userDetailEmail,
			String userDetailAddress1, String userDetailAddress2,
			String userDetailWorkPhoneNumber, String userDetailHomePhoneNumber,
			String userDetailMobilPhoneNumber,
			Timestamp userDetailSubscriptionStart,
			Timestamp userDetailSubscriptionEndDate, boolean userDetailActive,
			Timestamp created, Timestamp modified, Set userProfiles) {
		super(user, state, zipCode, city, country, userDetailFirstName,
				userDetailLastName, userDetailEmail, userDetailAddress1,
				userDetailAddress2, userDetailWorkPhoneNumber,
				userDetailHomePhoneNumber, userDetailMobilPhoneNumber,
				userDetailSubscriptionStart, userDetailSubscriptionEndDate,
				userDetailActive, created, modified, userProfiles);
	}

}
