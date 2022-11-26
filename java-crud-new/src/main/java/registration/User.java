package registration;

public class User {
	private int id;
	private String uname;
	private String upwd;
	private String uemail;
	private String umobile;
	
	public User(int id, String uname, String upwd, String uemail, String umobile) {
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
		this.uemail = uemail;
		this.umobile = umobile;
	}
	
	public int getId() {
		return id;
	}

	public String getUname() {
		return uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public String getUemail() {
		return uemail;
	}

	public String getUmobile() {
		return umobile;
	}
	
}
