public class test24 {
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onActionModeStarted(ActionMode mode) {
        super.onActionModeStarted(mode);
        articleView.mustBeArmedToScroll = false;
    }

}