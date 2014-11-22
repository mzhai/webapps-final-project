package formbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mybeans.form.FormBean;

public class RegisterForm extends FormBean {
	private String userName;
	private String email;
	private String password;
	private String confirm ;
	
	public String getUserName() { return userName; }
	public String getEmail()  { return email;  }
	public String getPassword()  { return password;  }
	public String getConfirm()   { return confirm;   }
	
	public void setUserName(String s) { userName = trimAndConvert(s,"<>\"");  }
	public void setEmail(String s)  { email  = trimAndConvert(s,"<>\"");  }
	public void setPassword(String s)  { password  = s.trim();                  }
	public void setConfirm(String s)   { confirm   = s.trim();                  }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (email == null || email.length() == 0) {
			errors.add("User Name is required");
		}else{
			if(!checkEmailValid(email)) {
				errors.add("Email is not valid");
			}
		}
		
		if (password == null || password.length() == 0) {
			errors.add("Password is required");
		}
		
		if (userName == null || userName.length() == 0) {
			errors.add("User Name is required");
		}
		
		if (confirm == null || confirm.length() == 0) {
			errors.add("Confirm Password is required");
		}
		
		if (errors.size() > 0) {
			return errors;
		}
		
		if (!password.equals(confirm)) {
			errors.add("Passwords are not the same");
		}
		
		return errors;
	}
	
	private boolean checkEmailValid(String e) {
		Pattern pattern = Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(e);
		
		return matcher.matches();
	}
}
