public class test112 {
synchronized public void refresh() {
        Log.d(TAG, "starting dictionary discovery");
        long t0 = System.currentTimeMillis();
        List<File> candidates = discover();
        Map<File, Exception> errors = open(candidates);
        for (File file : candidates) {
                String absolutePath = file.getAbsolutePath();
                if (!errors.containsKey(file)) {
                        dictionaryFileNames.add(absolutePath);
                }
                else {
                        Log.w(TAG, "Failed to open file " + absolutePath, errors.get(file));
                }
        }
        saveDictFileList();
        Log.d(TAG, "dictionary discovery took " + (System.currentTimeMillis() - t0));
    }

}