public class test30 {
public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_SEARCH) {
            finish();
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }

}