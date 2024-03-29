public class test60 {
protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT < 11) {
            getWindow().requestFeature(Window.FEATURE_LEFT_ICON);
        }
        registerProgressReceiver();
        initUI();
        if (android.os.Build.VERSION.SDK_INT < 11) {
            getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.aarddict);
        }
        Intent dictServiceIntent = new Intent(this, DictionaryService.class);
        startService(dictServiceIntent);
        bindService(dictServiceIntent, connection, 0);
    }

}