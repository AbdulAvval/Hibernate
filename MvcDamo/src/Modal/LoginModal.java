package Modal;

public class LoginModal 
{
	String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	String password;
	
	public boolean chekLogin()
	{
		if(username.equals("Abdul")&& password.equals("12345"))
		return true;
		else
			return false;
	}
}
