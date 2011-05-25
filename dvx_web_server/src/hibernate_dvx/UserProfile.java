package hibernate_dvx;

import java.sql.Timestamp;

/**
 * UserProfile entity. @author MyEclipse Persistence Tools
 */
public class UserProfile extends AbstractUserProfile implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public UserProfile() {
	}

	/** full constructor */
	public UserProfile(User user, UserDetail userDetail,
			Integer userProfileVisionImpared, Integer userProfileMotionImpared,
			Timestamp created, Timestamp modified) {
		super(user, userDetail, userProfileVisionImpared,
				userProfileMotionImpared, created, modified);
	}

}
