<h1 align="center">🎶 Mini Spotify</h1>
<p align="center"><i>a playlist app powered by a linked list I built myself</i></p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-Swing-ED8B00?logo=openjdk&logoColor=white">
  <img src="https://img.shields.io/badge/tested_with-JUnit-25A162">
  <img src="https://img.shields.io/badge/class-CMSC204-c9a0dc">
</p>

---

## 💿 What is it?

So, this is basically a tiny version of Spotify with a real desktop window. You log in, pick one of your playlists from a dropdown, and then flip through the songs with next and previous buttons. On top of that, you can add and remove songs right from the app.

The fun part, though, is what's under the hood. Instead of using Java's built in `LinkedList`, I wrote my own `GenericLinkedList<T>` with its own iterator. That way, the next and previous buttons are actually walking forward and backward through my list.

## ✨ Features

- **Log in** with a username and password (with custom exceptions if the user doesn't exist or the password is wrong)
- **Load users from a file**, including all their playlists and songs
- **Switch playlists** from a dropdown
- **Go through songs** with next and previous
- **Add or remove songs** while the app is running
- **Lots of JUnit tests** for the linked list, songs, playlists, users, and the manager

## 🚀 Running it

First, compile everything:

```bash
javac *.java
```

Then, start the app:

```bash
java SpotifySwingApp
```

After that, a file picker opens, so choose a user file. It should look something like this:

```
# USER
username: kubra
password: 1234
playlist: Study Vibes
song: Golden Hour - JVKE
song: Sunflower - Post Malone
```

Finally, type in the username and password from that file, and you're in!

## 📁 Files

| File | What it does |
|---|---|
| `GenericLinkedList.java` | my own doubly linked list and iterator |
| `Song.java`, `Playlist.java`, `User.java` | the main data classes |
| `SpotifyManager.java` | loads users from the file and handles logging in |
| `SpotifySwingApp.java` | the actual window you click around in |
| `*Test.java` | JUnit tests |

## 💭 What I learned

Mostly, I finally understood how iterators really work, since I had to write `next()`, `previous()`, and `remove()` myself. Also, building a GUI on top of my own data structure made it way more satisfying than just passing tests.
