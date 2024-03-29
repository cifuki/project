public class test90 {
private void verify(int position) {
            final List<Volume> allDictVols = volumes.get(position);
            final ProgressDialog progressDialog = new ProgressDialog(
                    DictionariesActivity.this);
            progressDialog.setIndeterminate(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setTitle(R.string.titleVerifying);
            progressDialog.setMessage(getTitle(allDictVols.get(0), false));
            progressDialog.setCancelable(true);
            final ProgressListener progressListener = new ProgressListener(
                    progressDialog, allDictVols.size());

            Runnable verify = new Runnable() {
                public void run() {
                    for (Volume d : allDictVols) {
                        try {
                            d.verify(progressListener);
                        } catch (Exception e) {
                            Log.e(TAG, "There was an error verifying volume "
                                    + d.getId(), e);
                            progressListener.proceed = false;
                            progressDialog.dismiss();
                            showError(getString(R.string.msgErrorVerifying,
                                    d.getDisplayTitle(),
                                    e.getLocalizedMessage()));
                        }
                    }
                }
            };

            progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
                    getString(R.string.btnCancel), new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            progressListener.proceed = false;
                        }
                    });
            progressDialog.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    progressListener.proceed = false;
                }
            });
            Thread t = new Thread(verify);
            t.setPriority(Thread.MIN_PRIORITY);
            t.start();
            progressDialog.show();
        }

}