public class test23 {
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onActionModeFinished(ActionMode mode) {
        super.onActionModeFinished(mode);
        articleView.mustBeArmedToScroll = true;
    }

}