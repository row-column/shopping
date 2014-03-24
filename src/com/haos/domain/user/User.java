package com.haos.domain.user;

import java.io.Serializable;
import java.util.Date;

/**
 * User information value class
 * @author WangYue
 *
 */
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	   
	/**
	 * ID
	 */
	private Long id;
	
	/**
	 * User code
	 */
	private String userCode;
	
	/**
	 * User name
	 */
	private String userName;
	
	/**
	 * user old password
	 */
	private String oldPassword;
	
	/**
	 * user password
	 */
	private String password;
	
	/**
	 * levelCode
	 */
	private String levelCode;
	
	/**
	 * levelName
	 */
	private String levelName;
	
	/**
	 * user sex
	 */
	private int sex;
	
	/**
	 * user mobile
	 */
	private String mobile;
	
	/**
	 * user email
	 */
	private String email;
	
	/**
	 * user add
	 */
	private String address;
	
	/**
	 * user id card
	 */
	private String idCard;
	
	/**
	 * user birthday
	 */
	private Date birthday;
	
	/**
	 * user hobbies
	 */
	private String hobbies;
	
	/**
	 * user photo
	 */
	private String userPhoto;
	
	/**
	 * comment count
	 */
	private Long commentCount;
	
	/**
	 * integral
	 */
	private Long integral;
	
	/**
	 * user register date
	 */
	private Date reqDate;
	
	/**
	 * user create time
	 */
	private Date createTime;
	
	/**
	 * user update time
	 */
	private Date updateTime;
	
	/**
	 * user yes or no delete
	 */
	private int yn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public Long getIntegral() {
		return integral;
	}

	public void setIntegral(Long integral) {
		this.integral = integral;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getYn() {
		return yn;
	}

	public void setYn(int yn) {
		this.yn = yn;
	}
	
	

}
