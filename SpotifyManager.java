import java.util.*;
import java.io.*;

public class SpotifyManager {
	private GenericLinkedList<User> users = new GenericLinkedList<>();
	public GenericLinkedList<User> getUsers(){
		return users;
	}
	public void loadUsersFromFile(String filename) throws IOException, InvalidUserFormatException {
	    Scanner scanner = new Scanner(new File(filename));
	    User currentUser = null;
	    Playlist currentPlaylist = null;

	    while (scanner.hasNextLine()) {
	        String line = scanner.nextLine().trim();

	        if (line.equals("# USER")) {
	            currentUser = null;
	        } else if (line.contains("username:")) {
	            currentUser = new User(line.substring(10).trim(), "");
	        } else if (line.contains("password:")) {
	            currentUser.setPass(line.substring(10).trim());
	            users.addLast(currentUser);
	        } else if (line.contains("playlist:")) {
	            currentPlaylist = new Playlist(line.substring(9).trim());
	            currentUser.addPlaylist(currentPlaylist);
	        } else if (line.contains("song:")) {
	            String[] parts = line.substring(6).trim().split(" - ");
	            currentPlaylist.addSong(new Song(parts[0], parts[1]));
	        }
	    }
	    scanner.close();
	}
	public User findUser(String username, String password) throws UserNotFoundException, InvalidPasswordException {
	    for (User user : users) {
	        if (user.getUsername().equals(username)) {
	            if (user.getPass().equals(password)) {
	                return user;
	            } else {
	                throw new InvalidPasswordException("Invalid password");
	            }
	        }
	    }
	    throw new UserNotFoundException("User not found");
	}
}
