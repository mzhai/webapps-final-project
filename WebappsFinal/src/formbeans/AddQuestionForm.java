package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class AddQuestionForm extends FormBean {
	private String button         = "";
	private String content        = "";
	private String title            = "";
	private String company 			= "other";
	private String catagory         = "other";
	private String language         = "other";
	
	public String       getButton()         { return button;         }
	public String       getContent()        { return content;        }
	public String		getTitle()			{ return title;			 }
	public String 		getCompany()		{ return company;	     }
	public String		getCatagory()		{ return catagory;		 }
	public String		getLanguage()		{ return language;		 }

	public void setButton(String s)         { button      = s;        }
	public void setContent(String s)        { content     = trimAndConvert(s,"<>\""); }
	public void setTitle(String s)			{ title 	  = trimAndConvert(s, "<>\"");		  }
	public void setCompany(String s)		{ company     = s;		  }
	public void setCatagory(String s)		{ catagory     = s;		  }
	public void setLanguage(String s)		{ language     = s;		  }
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (title == null || title.length() == 0) {
			errors.add("Title is required");
		}
		
		if (content == null || content.length() == 0) {
			errors.add("Content is required");
		}

		return errors;
	}
	
	
}
