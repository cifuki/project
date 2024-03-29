public class test178 {
static LookupWord splitWordSimple(String word) {
        String[] parts = word.split("#", 2);
        String section = parts.length == 1 ? null : parts[1];
        String nsWord = (!isEmpty(parts[0]) || !isEmpty(section)) ? parts[0] : word;
        String[] nsParts = nsWord.split(":", 2);
        String lookupWord = nsParts.length == 1 ? nsParts[0] : nsParts[1];
        lookupWord = lookupWord.replace("_", " ");
        String nameSpace = nsParts.length == 1 ? null : nsParts[0];
        return new LookupWord(nameSpace, lookupWord, section);
    }

}