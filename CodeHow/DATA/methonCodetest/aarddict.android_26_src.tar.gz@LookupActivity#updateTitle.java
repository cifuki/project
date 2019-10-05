public class test161 {
void updateTitle() {
        int dictCount = dictionaryService.getVolumes().size();
        Resources r = getResources();
        String dictionaries = r.getQuantityString(R.plurals.dictionaries, dictCount);
        String appName = r.getString(R.string.appName);
        String mainTitle = r.getString(R.string.titleLookupActivity, appName, String.format(dictionaries, dictCount));
        setTitle(mainTitle);
    }

}