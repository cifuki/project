public class test238 {
public Volume(File file, File cacheDir, Map<UUID, Metadata> knownMeta) throws IOException, FormatException {
        this.origFile = file;
        init(new RandomAccessFile(file, "r"), cacheDir, knownMeta);
    }

}