package hibernate_dvx;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractUserDetail entity provides the base persistence definition of the
 * UserDetail entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserDetail extends HibernateBaseClass implements
		java.io.Serializable {

	// Fields

	private Integer userDetailId;
	private User user;
	private State state;
	private ZipCode zipCode;
	private City city;
	private Country country;
	private String userDetailFirstName;
	private String userDetailLastName;
	private String userDetailEmail;
	private String userDetailAddress1;
	private String userDetailAddress2;
	private String userDetailWorkPhoneNumber;
	private String userDetailHomePhoneNumber;
	private String userDetailMobilPhoneNumber;
	private Date userDetailSubscriptionStart;
	private Date userDetailSubscriptionEndDate;
	private Boolean userDetailActive;
	private Timestamp created;
	private Timestamp modified;
	private Set userProfiles = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractUserDetail() {
	}

	/** minimal constructor */
	public AbstractUserDetail(User user) {
		this.user = user;
	}

	/** full constructor */
	public AbstractUserDetail(User user, State state, ZipCode zipCode,
			City city, Country country, String userDetailFirstName,
			String userDetailLastName, String userDetailEmail,
			String userDetailAddress1, String userDetailAddress2,
			String userDetailWorkPhoneNumber, String userDetailHomePhoneNumber,
			String userDetailMobilPhoneNumber,
			Date userDetailSubscriptionStart,
			Date userDetailSubscriptionEndDate, Boolean userDetailActive,
			Timestamp created, Timestamp modified, Set userProfiles) {
		this.user = user;
		this.state = state;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.userDetailFirstName = userDetailFirstName;
		this.userDetailLastName = userDetailLastName;
		this.userDetailEmail = userDetailEmail;
		this.userDetailAddress1 = userDetailAddress1;
		this.userDetailAddress2 = userDetailAddress2;
		this.userDetailWorkPhoneNumber = userDetailWorkPhoneNumber;
		this.userDetailHomePhoneNumber = userDetailHomePhoneNumber;
		this.userDetailMobilPhoneNumber = userDetailMobilPhoneNumber;
		this.userDetailSubscriptionStart = userDetailSubscriptionStart;
		this.userDetailSubscriptionEndDate = userDetailSubscriptionEndDate;
		this.userDetailActive = userDetailActive;
		this.created = created;
		this.modified = modified;
		this.userProfiles = userProfiles;
	}

	// Property accessors

	public Integer getUserDetailId() {
		return this.userDetailId;
	}

	public void setUserDetailId(Integer userDetailId) {
		this.userDetailId = userDetailId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public ZipCode getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(ZipCode zipCode) {
		this.zipCode = zipCode;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getUserDetailFirstName() {
		return this.userDetailFirstName;
	}

	public void setUserDetailFirstName(String userDetailFirstName) {
		this.userDetailFirstName = userDetailFirstName;
	}

	public String getUserDetailLastName() {
		return this.userDetailLastName;
	}

	public void setUserDetailLastName(String userDetailLastName) {
		this.userDetailLastName = userDetailLastName;
	}

	public String getUserDetailEmail() {
		return this.userDetailEmail;
	}

	public void setUserDetailEmail(String userDetailEmail) {
		this.userDetailEmail = userDetailEmail;
	}

	public String getUserDetailAddress1() {
		return this.userDetailAddress1;
	}

	public void setUserDetailAddress1(String userDetailAddress1) {
		this.userDetailAddress1 = userDetailAddress1;
	}

	public String getUserDetailAddress2() {
		return this.userDetailAddress2;
	}

	public void setUserDetailAddress2(String userDetailAddress2) {
		this.userDetailAddress2 = userDetailAddress2;
	}

	public String getUserDetailWorkPhoneNumber() {
		return this.userDetailWorkPhoneNumber;
	}

	public void setUserDetailWorkPhoneNumber(String userDetailWorkPhoneNumber) {
		this.userDetailWorkPhoneNumber = userDetailWorkPhoneNumber;
	}

	public String getUserDetailHomePhoneNumber() {
		return this.userDetailHomePhoneNumber;
	}

	public void setUserDetailHomePhoneNumber(String userDetailHomePhoneNumber) {
		this.userDetailHomePhoneNumber = userDetailHomePhoneNumber;
	}

	public String getUserDetailMobilPhoneNumber() {
		return this.userDetailMobilPhoneNumber;
	}

	public void setUserDetailMobilPhoneNumber(String userDetailMobilPhoneNumber) {
		this.userDetailMobilPhoneNumber = userDetailMobilPhoneNumber;
	}

	public Date getUserDetailSubscriptionStart() {
		return this.userDetailSubscriptionStart;
	}

	public void setUserDetailSubscriptionStart(Date userDetailSubscriptionStart) {
		this.userDetailSubscriptionStart = userDetailSubscriptionStart;
	}

	public Date getUserDetailSubscriptionEndDate() {
		return this.userDetailSubscriptionEndDate;
	}

	public void setUserDetailSubscriptionEndDate(
			Date userDetailSubscriptionEndDate) {
		this.userDetailSubscriptionEndDate = userDetailSubscriptionEndDate;
	}

	public Boolean getUserDetailActive() {
		return this.userDetailActive;
	}

	public void setUserDetailActive(Boolean userDetailActive) {
		this.userDetailActive = userDetailActive;
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

}