public class test185 {
@SuppressWarnings("rawtypes")
    Map<String, String> getInterwikiMap() {
        if (interwikiMap == null) {
            interwikiMap = new HashMap<String, String>();
            if (siteinfo != null) {
                Log.d(TAG, "Siteinfo not null");
                List interwiki = (List) siteinfo.get("interwikimap");
                if (interwiki != null) {
                    Log.d(TAG, "Interwiki map not null");
                    for (Object item : interwiki) {
                        Map interwikiItem = (Map) item;
                        String prefix = (String) interwikiItem.get("prefix");
                        String url = (String) interwikiItem.get("url");
                        interwikiMap.put(prefix, url);
                    }
                }
            }
        }
        return interwikiMap;
    }

}