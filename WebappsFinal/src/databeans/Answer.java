package databeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Answer implements Comparable<Answer>{
    private int    id          = -1;

    private String content     = null;
    private String owner       = null;
    private String qst         = null;
    private String date	       = null;
    private int    clicks      = 0;
	
    /*
     * Here we compare number of clicks
     */
    public int compareTo(Answer other) {
    	return clicks - other.clicks;
    }
	
    public boolean equals(Object obj) {
    	if (obj instanceof Answer) {
    		Answer other = (Answer) obj;
    		return compareTo(other) == 0;
    	}
    	return false;
    }
	
    public int    getId()          { return id;          }
    public String getContent()     { return content;     }
    public String getOwner()       { return owner;       }
    public String getQst()         { return qst;         }
    public String getDate()			{ return date; }
    public int    getClicks()      { return clicks;      }
 
    public void setId(int x)              { id = x;           }
    public void setContent(String s)     { content = s;     }
    public void setOwner(String email)       { owner = email;       }
    public void setQst(String s)         { qst=s;         }
    public void setDate()				{ date = getDateTime(); }
    public void setClicks(int count)      { clicks = count;   }
    
    public void incrClicks()			  { clicks = clicks +1; }
    
    public String toString() {
    	return "Answer("+id+")";
    }
    
    //helper function to get current date
    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
