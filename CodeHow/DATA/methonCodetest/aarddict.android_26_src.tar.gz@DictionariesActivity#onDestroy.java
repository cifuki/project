public class test68 {
@Override
    protected void onDestroy() {
        super.onDestroy();
        if (dataAdapter != null) {
            dataAdapter.destroy();
        }
    }

}