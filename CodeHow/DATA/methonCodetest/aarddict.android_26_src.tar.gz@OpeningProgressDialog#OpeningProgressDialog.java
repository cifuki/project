public class test187 {
OpeningProgressDialog(Context context) {
        super(context);
        setCancelable(false);
        setIndeterminate(false);
        setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        setProgress(0);
        setMessage(context.getString(R.string.msgLoading));
    }

}