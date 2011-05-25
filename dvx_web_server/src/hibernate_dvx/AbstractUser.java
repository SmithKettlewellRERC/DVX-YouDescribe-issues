package hibernate_dvx;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userPassword;
	private Timestamp userLastLogin;
	private Boolean userActive;
	private Integer userType;
	private Timestamp created;
	private Timestamp modified;
	private Set userProfiles = new HashSet(0);
	private Set authors = new HashSet(0);
	private Set userDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}

	/** minimal constructor */
	public AbstractUser(Boolean userActive, Integer userType) {
		this.userActive = userActive;
		this.userType = userType;
	}

	/** full constructor */
	public AbstractUser(String userName, String userPassword,
			Timestamp userLastLogin, Boolean userActive, Integer userType,
			Timestamp created, Timestamp modified, Set userProfiles,
			Set authors, Set userDetails) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userLastLogin = userLastLogin;
		this.userActive = userActive;
		this.userType = userType;
		this.created = created;
		this.modified = modified;
		this.userProfiles = userProfiles;
		this.authors = authors;
		this.userDetails = userDetails;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Timestamp getUserLastLogin() {
		return this.userLastLogin;
	}

	public void setUserLastLogin(Timestamp userLastLogin) {
		this.userLastLogin = userLastLogin;
	}

	public Boolean getUserActive() {
		return this.userActive;
	}

	public void setUserActive(Boolean userActive) {
		this.userActive = userActive;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
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

	public Set getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(Set userProfiles) {
		this.userProfiles = userProfiles;
	}

	public Set getAuthors() {
		return this.authors;
	}

	public void setAuthors(Set authors) {
		this.authors = authors;
	}

	public Set getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(Set userDetails) {
		this.userDetails = userDetails;
	}

}