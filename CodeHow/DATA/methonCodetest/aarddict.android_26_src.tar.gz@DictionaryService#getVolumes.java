public class test101 {
@SuppressWarnings({ "unchecked", "rawtypes" })
    public Map<UUID, List<Volume>> getVolumes() {
        Map<UUID, List<Volume>> result = new LinkedHashMap();
        for (Volume d : library) {
                UUID dictionaryId = d.getDictionaryId();
                        if (!result.containsKey(dictionaryId)) {
                                result.put(dictionaryId, new ArrayList<Volume>());
                        }
                        result.get(dictionaryId).add(d);
        }
        return result;
    }

}