public class test113 {
void saveDictFileList() {
        try {
            File dir = getDir(DICTDIR, 0);
            File file = new File(dir, DICTFILE);
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(new ArrayList<String>(dictionaryFileNames));
        }
        catch (Exception e) {
            Log.e(TAG, "Failed to save dictionary file list", e);
        }
    }

}