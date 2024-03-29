public class test118 {
@Override
            public void onEvent(int event, String path) {
            if ((event & FileObserver.DELETE) != 0) {
                Log.d(TAG, String.format("Received file event %s: %s", event, path));
                if (dictFilesToWatch.contains(path)) {
                    Log.d(TAG, String.format("Dictionary file %s in %s has been deleted, stopping service", path, dir));
                    if (dictionaryFileNames.remove(new File(dir, path).getAbsolutePath()))
                        saveDictFileList();
                    stopSelf();
                }
            }
            }

}