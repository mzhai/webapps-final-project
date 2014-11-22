package formbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mybeans.form.FormBean;

public class LoginForm extends FormBean {
	private String email;
	private String password;
	
	public String getEmail()  { return email; }
	public String getPassword()  { return password; }
	
	public void setEmail(String s) { email = trimAndConvert(s,"<>\"");  }
	public void setPassword(String s) {	password = s.trim();                  }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (email == null || email.length() == 0) {
			errors.add("User email is required");
		}else{
			if(!checkEmailValid(email)) {
				errors.add("Email is not valid");
			}
		}
		
		if (password == null || password.length() == 0) {
			errors.add("Password is required");
		}
		
		return errors;
	}
	
	private boolean checkEmailValid(String e) {
		Pattern pattern = Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(e);
		
		return matcher.matches();
	}
}