public class test172 {
public WordAdapter(Iterator<Entry> results) {
            this.results = results;
            this.words = new ArrayList<Entry>();
            loadBatch();
            mInflater = (LayoutInflater) LookupActivity.this.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
        }

}