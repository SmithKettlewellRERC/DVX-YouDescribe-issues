package hibernate_dvx;

import java.sql.Timestamp;

/**
 * AbstractUserProfile entity provides the base persistence definition of the
 * UserProfile entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserProfile extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer userProfileId;
	private User user;
	private UserDetail userDetail;
	private Integer userProfileVisionImpared;
	private Integer userProfileMotionImpared;
	private Timestamp created;
	private Timestamp modified;

	// Constructors

	/** default constructor */
	public AbstractUserProfile() {
	}

	/** full constructor */
	public AbstractUserProfile(User user, UserDetail userDetail,
			Integer userProfileVisionImpared, Integer userProfileMotionImpared,
			Timestamp created, Timestamp modified) {
		this.user = user;
		this.userDetail = userDetail;
		this.userProfileVisionImpared = userProfileVisionImpared;
		this.userProfileMotionImpared = userProfileMotionImpared;
		this.created = created;
		this.modified = modified;
	}

	// Property accessors

	public Integer getUserProfileId() {
		return this.userProfileId;
	}

	public void setUserProfileId(Integer userProfileId) {
		this.userProfileId = userProfileId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public Integer getUserProfileVisionImpared() {
		return this.userProfileVisionImpared;
	}

	public void setUserProfileVisionImpared(Integer userProfileVisionImpared) {
		this.userProfileVisionImpared = userProfileVisionImpared;
	}

	public Integer getUserProfileMotionImpared() {
		return this.userProfileMotionImpared;
	}

	public void setUserProfileMotionImpared(Integer userProfileMotionImpared) {
		this.userProfileMotionImpared = userProfileMotionImpared;
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