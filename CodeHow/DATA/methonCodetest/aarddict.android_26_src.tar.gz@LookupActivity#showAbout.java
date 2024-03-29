public class test159 {
private void showAbout() {
        PackageManager manager = getPackageManager();
        String versionName = "";
        try {
                        PackageInfo info = manager.getPackageInfo(getPackageName(), 0);
                        versionName = info.versionName;
                } catch (NameNotFoundException e) {
                        Log.e(TAG, "Failed to load package info for " + getPackageName(), e) ;
                }

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.FILL_PARENT, 1));
        layout.setPadding(10, 10, 10, 10);
        ImageView logo = new ImageView(this);
        logo.setImageResource(R.drawable.aarddict);
        logo.setPadding(0, 0, 20, 0);
        logo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.FILL_PARENT));
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setLineSpacing(2f, 1);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.FILL_PARENT));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(Html.fromHtml(getString(R.string.about, getString(R.string.appName), versionName)));

        LinearLayout textViewLayout = new LinearLayout(this);
        textViewLayout.setOrientation(LinearLayout.VERTICAL);
        textViewLayout.setPadding(0, 0, 0, 10);
        textViewLayout.addView(textView);

        layout.addView(logo);
        layout.addView(textViewLayout);

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(R.string.titleAbout).setView(layout).setNeutralButton(R.string.btnDismiss, new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogBuilder.show();
        }

}