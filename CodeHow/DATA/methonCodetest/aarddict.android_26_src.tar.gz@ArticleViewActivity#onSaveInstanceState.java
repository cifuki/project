public class test36 {
@SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("backItems", new LinkedList(backItems));
        outState.putSerializable("scrollPositionsH", new HashMap(
                scrollPositionsH));
        outState.putSerializable("scrollPositionsV", new HashMap(
                scrollPositionsV));
    }

}