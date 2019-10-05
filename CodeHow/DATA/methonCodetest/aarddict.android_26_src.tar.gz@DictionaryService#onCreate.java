public class test106 {
@Override
        public void onCreate() {
                Log.d(TAG, "On create");
                library = new Library();
                loadDictFileList();
                broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                Uri path = intent.getData();
                Log.d(TAG, String.format("action: %s, path: %s", action, path));
                stopSelf();
            }
                };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("file");
        intentFilter.addAction(Intent.ACTION_MEDIA_EJECT);
        intentFilter.addAction(Intent.ACTION_MEDIA_BAD_REMOVAL);
        intentFilter.addAction(Intent.ACTION_MEDIA_REMOVED);
                registerReceiver(broadcastReceiver, intentFilter);
        }

}