public class test110 {
synchronized public void openDictionaries() {
                Log.d(TAG, "opening dictionaries");
                long t0 = System.currentTimeMillis();
                List<File> candidates = new ArrayList<File>();
                for (String path : dictionaryFileNames) {
                        candidates.add(new File(path));
                }
                Map<File, Exception> errors = open(candidates);
                boolean saveFileNames = false;
                for (File file : errors.keySet()) {
                    String fileName = file.getAbsolutePath();
                    Log.d(TAG, "Removing file name from dictionary file names: " + fileName);
                    saveFileNames = dictionaryFileNames.remove(fileName);
                }
                if (saveFileNames) {
                    saveDictFileList();
                }
                Log.d(TAG, "dictionaries opened in " + (System.currentTimeMillis() - t0));
        }

}