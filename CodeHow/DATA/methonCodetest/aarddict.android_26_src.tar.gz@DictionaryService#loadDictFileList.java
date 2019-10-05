public class test103 {
@SuppressWarnings("unchecked")
    void loadDictFileList() {
        try {
            File dir = getDir(DICTDIR, 0);
            File file = new File(dir, DICTFILE);
            if (file.exists()) {
                FileInputStream fin = new FileInputStream(file);
                ObjectInputStream oin = new ObjectInputStream(fin);
                List<String> data  = (List<String>)oin.readObject();
                dictionaryFileNames.addAll(data);
            }
        }
        catch (Exception e) {
            Log.e(TAG, "Failed to load dictionary file list", e);
        }
    }

}