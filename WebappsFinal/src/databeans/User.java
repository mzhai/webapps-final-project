package databeans;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class User implements Comparable<User> {
	private String  email = null;

	private String  hashedPassword = "*";
	private int     salt           = 0;

	private String  userName      = null;

	public User(String email) {
		this.email = email;
	}

	public boolean checkPassword(String password) {
		return hashedPassword.equals(hash(password));
	}
	
	public int compareTo(User other) {
		// Order first by lastName and then by firstName
		int c = userName.compareTo(other.userName);
		if (c != 0) return c;
		return email.compareTo(other.email);
	}

	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User other = (User) obj;
			return email.equals(other.email);
		}
		return false;
	}

	public String  getHashedPassword() { return hashedPassword; }
	public String  getEmail()       { return email;       }
	public int     getSalt()           { return salt;           }

	public String  getUserName()       { return userName;       }

	public int     hashCode()          { return userName.hashCode(); }

	public void setHashedPassword(String x) { hashedPassword = x; }
	public void setPassword(String s)       { salt = newSalt(); hashedPassword = hash(s); }
	public void setSalt(int x)              { salt = x;           }

	public void setUserName(String s)      { userName = s;      }
	public void setUderEmail(String s)		{ email = s; }

	public String toString() {
		return "User("+getEmail()+")";
	}

	private String hash(String clearPassword) {
		if (salt == 0) return null;

		MessageDigest md = null;
		try {
		  md = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
		  throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}

		String saltString = String.valueOf(salt);
		
		md.update(saltString.getBytes());
		md.update(clearPassword.getBytes());
		byte[] digestBytes = md.digest();

		// Format the digest as a String
		StringBuffer digestSB = new StringBuffer();
		for (int i=0; i<digestBytes.length; i++) {
		  int lowNibble = digestBytes[i] & 0x0f;
		  int highNibble = (digestBytes[i]>>4) & 0x0f;
		  digestSB.append(Integer.toHexString(highNibble));
		  digestSB.append(Integer.toHexString(lowNibble));
		}
		String digestStr = digestSB.toString();

		return digestStr;
	}

	private int newSalt() {
		Random random = new Random();
		return random.nextInt(8192)+1;  // salt cannot be zero
	}
}
