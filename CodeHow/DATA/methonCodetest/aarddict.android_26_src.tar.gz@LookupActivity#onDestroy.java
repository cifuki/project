public class test155 {
@Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

}