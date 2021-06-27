import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FileTypeFilter extends FileFilter{
	private final String extension;
	private final String description;
	
	public FileTypeFilter(String extension, String description) {
		this.description = description;
		this.extension = extension;
	}
	
	@Override
	public boolean accept(File file) {
		if(file.isDirectory()) {
			return true;
		}
		return file.getName().endsWith(extension);
	}
	@Override
	public String getDescription() {
		return description + String.format(" (*%s)",extension);
	}
	
}
