package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class AddAnswerForm extends FormBean {
	private String button         = "";
	private String content        = "";
	private String qst		      = "";
	
	public String       getButton()         { return button;         }
	public String       getContent()        { return content;        }
	public String 		getQst()			{ return qst; 			 }

	public void setButton(String s)         { button      = s;        }
	public void setComment(String s)        { content     = trimAndConvert(s,"<>\""); }
	public void setQst(String s)			{ qst 		  = trimAndConvert(s,"<>\""); }

	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (content == null || content.length() == 0) {
			errors.add("Content is required");
		}

		return errors;
	}
	
	
}
