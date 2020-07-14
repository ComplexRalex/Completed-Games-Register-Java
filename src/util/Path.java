package util;

import java.io.File;

public class Path {
	/**
	 * Source code folder path 
	 * */
	public static final String srcPath = "src/";			// Every important file goes here
	/** 
	 * Data files folder path
	 * */
	public static final String dataPath = "data/";			// Every user-mofified file goes here
	
	/**
	 * Save file path
	 */
	public static final String saveFile = dataPath+"save.dat";
	/**
	 * Configuration file path
	 */
	public static final String configFile = dataPath+"config.dat";

	/**
	 * Backup files folder path
	 */
	public static final String backupPath = dataPath+"backup/";
	
	/**
	 * Game Database API data folder
	 */
	public static final String gamePath = dataPath+"game/";
	/**
	 * Game information folder path
	 */
	public static final String gameInfo = gamePath+"json/";
	/**
	 * Game image folder path
	 */
	public static final String gameImage = gamePath+"image/";

	/**
	 * Image folder path
	 */
	public static final String imagePath = srcPath+"image/";

	/**
	 * Creates a file name with the given name in lower case, without any
	 * symbols different from:<p>
	 * - "<b>a</b>" to "<b>z</b>" characters,<p>
	 * - "<b>()</b>" parenthesis,<p>
	 * - space character,<p>
	 * - "<b>0</b>" to "<b>9</b>" numbers,<p>
	 * - and "<b>+</b>", "<b>-</b>" symbols.<p>
	 * Also, the space characters will be replaced to "<b>_</b>" characters.
	 * 
	 * @param name String which contains the name of the file
	 * @param extension String which contains the format of the file. Note
	 * that this must NOT include the "<b>.</b>" symbol
	 * @return String with the mentioned changes
	 */
	public static final String validFileName(String name, String extension){
		return name.toLowerCase().replaceAll("[^ ()a-z0-9+-]","").replaceAll(" ","_")+"."+extension;
	}

	/**
	 * Verifies if the given path exists.
	 * 
	 * @param path String which contains the path name.
	 * @return <b>true</b> if the directory/file exists. <b>false</b>
	 * otherwise.
	 */
	public static final boolean exists(String path){
		return (new File(path)).exists();
	}

	/**
	 * Creates a directory with the specified path in case of the
	 * non-existence of such (including parent folders). Note that
	 * this will only work with directories and not files.
	 * 
	 * @param path String which contains the path name.
	 * @return <b>true</b> if the directory(s) was created successfully.
	 * <b>false</b> otherwise.
	 */
	public static final boolean resolve(String path){
		return (new File(path)).mkdirs();
	}

}
