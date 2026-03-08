import java.util.ListIterator;

public class Playlist {
	
	private String name;
	private GenericLinkedList<Song> songs;
	private ListIterator<Song> iterator;
	private Song currentSong;
	
	public Playlist(String name) {
		this.name  = name;
		this.songs= new GenericLinkedList<>();
		this.iterator = songs.iterator();
		this.currentSong = null;
	}
	public String getName() {
		return name;
	}
	Boolean addSong(Song song) {
		songs.addLast(song);
		iterator = songs.iterator();
		return true;
	}
	Song getCurrentSong() {
		if(currentSong == null && !songs.isEmpty()) {
			return songs.getFirst();
		}
		return currentSong;
	}
	int getSize() {
		return songs.size();
	}
	GenericLinkedList<Song> getSongs(){
		return songs;
	}
	Boolean isEmpty() {
		return songs.isEmpty();
	}
	Song nextSong() {
		if(iterator.hasNext()) {
			currentSong = iterator.next();
			return currentSong;
		}
		return null;
	}
	Song previousSong() {
        if (iterator.hasPrevious()) {
            currentSong = iterator.previous();
            return currentSong;
        }
        return null;
}
	Boolean removeSong(Song song) {
		boolean removed = songs.remove(song);
		if(removed) {
			currentSong = null;
			iterator = songs.iterator();
		}
		return removed;
	}
}