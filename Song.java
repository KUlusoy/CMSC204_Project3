import java.util.Objects;

public class Song {
private String songName;
private String artist;

public Song(String songName, String artist) {
	this.songName = songName;
	this.artist = artist;
}


public String getSongName() {
	return songName;
}
public void setSongName(String songName) {
	this.songName = songName;
}
public String getArtist() {
	return artist;
}
public void setArtist(String artist) {
	this.artist = artist;
}
public String toString() {
	return songName +" - " + artist;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Song other = (Song) obj;
	return Objects.equals(artist, other.artist) && Objects.equals(songName, other.songName);
}



}
