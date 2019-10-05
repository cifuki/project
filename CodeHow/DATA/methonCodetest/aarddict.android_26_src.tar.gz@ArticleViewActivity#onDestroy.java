public class test27 {
@Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        scrollPositionsH.clear();
        scrollPositionsV.clear();
        backItems.clear();
    }

}