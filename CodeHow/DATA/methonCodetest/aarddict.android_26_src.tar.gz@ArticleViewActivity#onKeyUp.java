public class test31 {
@Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // eat key ups corresponding to key downs so that volume keys don't beep
        switch (keyCode) {
        case KeyEvent.KEYCODE_BACK:
        case KeyEvent.KEYCODE_VOLUME_UP:
        case KeyEvent.KEYCODE_VOLUME_DOWN:
            break;
        default:
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }

}