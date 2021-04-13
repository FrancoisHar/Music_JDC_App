package junia.adimaker.songapplication;

public class Song
{
    private final long id;
    private final String title;
    private final String artist;


    public Song(long songID, String songTitle, String songArtist)
    {
        id = songID;
        title = songTitle;
        artist = songArtist;
    }
    public long getID()
    {return id;}
    public String getTitle()
    {return title;}
    public String getArtist()
    {return artist;}
}