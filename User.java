
public class User {
private String username;
private String pass;
private GenericLinkedList<Playlist> playlists;

public User(String username, String pass) {
	this.username = username;
	this.pass = pass;
	this.playlists = new GenericLinkedList<>();
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public GenericLinkedList<Playlist> getPlaylists() {
	return playlists;
}

public void setPlaylists(GenericLinkedList<Playlist> playlists) {
	this.playlists = playlists;
}

public void addPlaylist(Playlist playlist) {
	playlists.addLast(playlist);
}
int getPlaylistCount() {
	return playlists.size();
}
@Override
public String toString() {
	return "User [username=" + username + ", pass=" + pass + ", playlists=" + playlists + "]";
}

}
