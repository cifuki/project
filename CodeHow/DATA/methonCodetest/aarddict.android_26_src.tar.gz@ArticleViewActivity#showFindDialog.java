public class test48 {
private void showFindDialog() {
        if (showFindDialogMethod != null) {
            try {
                showFindDialogMethod.invoke(articleView, "", true);
            } catch (Exception e) {
                Log.e(TAG, "", e);
            }
        }
    }

}