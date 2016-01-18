import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Método para mostrar todos los archivos almacenados en la colección.
     */
    public void listAllFiles(){
        int posicion = 1;
        for (String filename : files){
            posicion = posicion + 1;
            System.out.println(posicion + ".-" + filename);
        }
    }

    /**
     * Método para listar los archivos que contengan en su nombre el String pasado por parámetro
     */
    public void listMatching(String cadena){
        boolean contiene = false;
        for (String filename : files){
            if (filename.contains(cadena)){
                contiene = true;
                System.out.println(filename);
            }
        }
        if (contiene == false){
            System.out.println("No se han encontrado archivos que contengan la cadena " + cadena);
        }
    }

    /**
     * Método para reproducir los primeros segundos de todas las canciones de un determinado artista pasado por parámetro
     */
    public void reproducirVariasCanciones(String artista){
        for (String filename : files){
            if (filename.contains(artista)){
                player.playSample(filename);
            }
        }
    }

    /**
     * Método que muestra por pantalla el índice del primer archivo que contiene una cadena pasada por parametro.
     * Si no hay ninguno devolverá -1.
     */
    public int findFirst(String cadena){
        boolean found = false;
        int index = 0;
        String encontrado = null;
        while (!found && index < files.size()){
            String filename = files.get(index);
            if (filename.contains(cadena)){
                encontrado = filename;
                found = true;
            }
            index = index + 1;
        }
        return files.indexOf(encontrado);
    }
}
