public class test120 {
DiscoveryProgressDialog(Context context) {
        super(context);
        setCancelable(false);
        setIndeterminate(true);
        setProgressStyle(ProgressDialog.STYLE_SPINNER);
        setMessage(context.getString(R.string.msgLooking));
    }

}