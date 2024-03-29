public class test47 {
private void showError(final String message) {
        runOnUiThread(new Runnable() {
            public void run() {
                currentTask = null;
                setProgress(10000);
                resetTitleToCurrent();
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(
                        ArticleViewActivity.this);
                dialogBuilder
                        .setTitle(R.string.titleError)
                        .setMessage(message)
                        .setNeutralButton(R.string.btnDismiss,
                                new OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                            int which) {
                                        dialog.dismiss();
                                        if (backItems.isEmpty()) {
                                            finish();
                                        }
                                    }
                                });
                dialogBuilder.show();
            }
        });
    }

}