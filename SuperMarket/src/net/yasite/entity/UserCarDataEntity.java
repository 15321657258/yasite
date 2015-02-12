package net.yasite.entity;

public class UserCarDataEntity {
	private UserCarEntity data;

	public UserCarEntity getData() {
		return data;
	}

	public void setData(UserCarEntity data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "UserCarDataEntity [data=" + data + "]";
	}
	
}
