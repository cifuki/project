public class test35 {
@SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        backItems = Collections.synchronizedList((List) savedInstanceState
                .getSerializable("backItems"));
        scrollPositionsH = Collections.synchronizedMap((Map) savedInstanceState
                .getSerializable("scrollPositionsH"));
        scrollPositionsV = Collections.synchronizedMap((Map) savedInstanceState
                .getSerializable("scrollPositionsV"));
    }

}