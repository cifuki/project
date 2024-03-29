public class test145 {
private List<UUID> findMatchingDicts(String serverUrl) {
        Log.d(TAG, "Looking for dictionary with server url " + serverUrl);
        Set<UUID> seen = new HashSet<UUID>();
        List<UUID> result = new ArrayList<UUID>();
        if (serverUrl == null) {
            Log.d(TAG, "Server url is null");
            return result;
        }
        for (Volume d : this) {
            String articleURLTemplate = d.getArticleURLTemplate();
            Log.d(TAG, "Looking at article url template: " + articleURLTemplate);
            if (articleURLTemplate != null
                    && serverUrl.equals(articleURLTemplate)) {
                Log.d(TAG, String.format(
                        "Dictionary with server url %s found: %s", serverUrl,
                        d.getDictionaryId()));
                if (!seen.contains(d.getDictionaryId()))
                    result.add(d.getDictionaryId());
            }
        }
        if (result.isEmpty()) {
            Log.d(TAG, String.format("Dictionary with server url %s not found",
                    serverUrl));
        }
        return result;
    }

}