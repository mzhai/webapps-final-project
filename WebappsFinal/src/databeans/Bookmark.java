package databeans;

public class Bookmark implements Comparable<Bookmark>{
    private int    id          = -1;
	
    private String url     	   = null;
    private String comment     = null;
    private String owner       = null;
    private int    clicks      = 0;
	
    /*
     * Here we compare number of clicks
     */
    public int compareTo(Bookmark other) {
    	return clicks - other.clicks;
    }
	
    public boolean equals(Object obj) {
    	if (obj instanceof Bookmark) {
    		Bookmark other = (Bookmark) obj;
    		return compareTo(other) == 0;
    	}
    	return false;
    }
	
    public int    getId()          { return id;          }
    public String getUrl()         { return url;         }
    public String getComment()     { return comment;     }
    public String getOwner()       { return owner;       }
    public int    getClicks()      { return clicks;      }
 
    public void setId(int x)              { id = x;           }
    public void setUrl(String s)          { url = s;          }
    public void setComment(String s)      { comment = s;      }
    public void setOwner(String email)    { owner = email;    }
    public void setClicks(int count)      { clicks = count;   }
    
    public void incrClicks()			  { clicks = clicks +1; }
    
    public String toString() {
    	return "Bookmark("+id+")";
    }
}
