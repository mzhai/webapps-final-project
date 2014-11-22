package formbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.mybeans.form.FormBean;


public class AddBookmarkForm extends FormBean {
	private String button         = "";
	private String comment        = "";
	private String url            = "";
	
	public String       getButton()         { return button;         }
	public String       getComment()        { return comment;        }
	public String		getUrl()			{ return url;			 }

	public void setButton(String s)         { button      = s;        }
	public void setComment(String s)        { comment     = trimAndConvert(s,"<>\""); }
	public void setUrl(String s)			{ url 		  = s;		  }
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (url == null || url.length() == 0) {
			errors.add("Url is required");
		}
		
		if (comment == null || comment.length() == 0) {
			errors.add("Comment is required");
		}
		
		if(!checkValidUrl(url)) {
			errors.add("Url is not valid");
		}
		return errors;
	}
	private boolean checkValidUrl(String u) {
		Pattern pattern = Pattern.compile("^.+\\..+$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(u);
		
		return matcher.matches();
	}
	
	
}
