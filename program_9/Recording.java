

public class Recording {
	private String title;
	private String artist;
	private double playingTime;
	
	/**
	 * no-arg constructor
	 */
	public Recording() {
		this("Unknown","Unknown",0);
	}

	/**
	 * constructor: title is supplied
	 * @param title The recording title
	 */
	public Recording(String title) {
		this(title, "Unknown", 0);
	}
	
	/**
	 * constructor: title and artist is supplied
	 * @param title The recording title
	 * @param artist The artist title
	 */
	public Recording(String title, String artist) {
		this(title, artist, 0);
	}
	
	/**
	 * Constructor: title and artist and playing time is supplied
	 * @param title The recording title
	 * @param artist The recording artist
	 * @param playingTime the recordings playing time
	 */
	public Recording( String title, String artist, double playingTime) {
		//validate the parameters
		if (title == null ) {
			this.title = "Unknown";
		}
		else {
			this.title = title;
		}
		if (artist == null) {
			this.artist = "Uknown";
		}
		else {
			this.artist = artist;
		}
		if (playingTime < 0) {
			this.playingTime = 0;
		}
		else {
			this.playingTime = playingTime;
		}
	}
	
	/**
	 * Copy Constructor - deep copy
	 * @param song Another Recording object supplied
	 */
	public Recording(Recording song) {
		//invoke constructor with three arguments
		this(song.getTitle(), song.getArtist(), song.getPlayingTime());
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Recording other = (Recording) obj;
		if (this.artist != other.artist)
			return false;
		if (this.title != other.title)
			return false;
		if (this.playingTime != other.playingTime)
			return false;
		return true;
	}

	/**
	 * the setTitle method sets the title of recording
	 * @param title the String to store in the title field
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * the setArtist method sets the artist name of recording
	 * @param artist The String to store in the artist field
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
	/**
	 * the setPlayingTime method sets the playing time for the recording
	 * @param playingTime The value to store in the playTime field
	 */
	public void setPlayingTime(double playingTime) {
		this.playingTime = playingTime;
	}
	/**
	 * The getTitle method returns the title 
	 * @return the String in title field
	 */
	public String getTitle() {
		return title;
	}
	
	
	/**
	 * the getArtist method returns the artist name
	 * @return String in artist field
	 */
	public String getArtist() {
		return artist;
	}
	
	
	/**
	 * the getPlayingTime method returns the playingTime of recording
	 * @return value in playingTime field
	 */
	public double getPlayingTime() {
		return playingTime;
	}
	
	/**
	 * the getPlayingTimeAsString method returns the playTime of recording as a string
	 * @return value in playingTime field as String
	 */
	public String getPlayingTimeAsString() {
		String str = String.valueOf(playingTime);
		return str;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: " + title + "\nArtist: " + artist+ "\nPlaying Time: " + playingTime);
		return sb.toString();
	}
}
