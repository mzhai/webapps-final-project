package databeans;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Question implements Comparable<Question>{
    private int    id          = -1;
	
    private String title     	   = null;
    private String content     = null;
    private String owner       = null;
    private String company     = null;
    private String catagory	   = null;
    private String language    = null;
    private String date	       = null;
    private int    clicks      = 0;
    private int    answercount = 0;
	
    /*
     * Here we compare number of clicks
     */
    public int compareTo(Question other) {
    	return clicks - other.clicks;
    }
	
    public boolean equals(Object obj) {
    	if (obj instanceof Question) {
    		Question other = (Question) obj;
    		return compareTo(other) == 0;
    	}
    	return false;
    }
	
    public int    getId()          { return id;          }
    public String getTitle()         { return title;         }
    public String getContent()     { return content;     }
    public String getOwner()       { return owner;       }
    public String getCompany()         { return company;         }
    public String getCatagory()     { return catagory;     }
    public String getLanguage()       { return language;       }
    public String getDate()			{ return date; }
    public int getAnswerCount()     { return answercount;}
    public int    getClicks()      { return clicks;      }
 
    public void setId(int x)              { id = x;           }
    public void setTitle(String s)         { title =  s;         }
    public void setContent(String s)     { content = s;     }
    public void setOwner(String email)       { owner = email;       }
    public void setCompany(String s)         { company=s;         }
    public void setCatagory(String s)     { catagory=s;     }
    public void setLanguage(String s)       { language = s;       }
    public void setDate()				{ date = getDateTime(); }
    public void setAnswerCount(int count)     { answercount=count;}
    public void setClicks(int count)      { clicks = count;   }
    
    public void incrClicks()			  { clicks = clicks +1; }
    
    public String toString() {
    	return "Question("+id+")";
    }
    

    //helper function to get current date
    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
