public class test63 {
private void registerProgressReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DictionaryService.DICT_OPEN_FAILED);
        intentFilter.addAction(DictionaryService.DISCOVERY_STARTED);
        intentFilter.addAction(DictionaryService.DISCOVERY_FINISHED);
        intentFilter.addAction(DictionaryService.OPEN_FINISHED);
        intentFilter.addAction(DictionaryService.OPEN_STARTED);
        intentFilter.addAction(DictionaryService.OPENED_DICT);

        broadcastReceiver = new BroadcastReceiver() {

            ProgressDialog discoveryProgress;
            ProgressDialog openProgress;

            @Override
            public void onReceive(Context context, Intent intent) {
                String a = intent.getAction();
                if (a.equals(DictionaryService.DISCOVERY_STARTED)) {
                    Log.d(TAG, "dictionary disconvery started");
                    if (discoveryProgress == null) {
                        discoveryProgress = new DiscoveryProgressDialog(context);
                    }
                    discoveryProgress.show();
                } else
                if (a.equals(DictionaryService.DISCOVERY_FINISHED)) {
                    Log.d(TAG, "dictionary discovery finished");
                    if (discoveryProgress != null) {
                        discoveryProgress.dismiss();
                        discoveryProgress = null;
                    }
                } else
                if (a.equals(DictionaryService.OPEN_STARTED)) {
                    Log.d(TAG, "dictionary open started");
                    int count = intent.getIntExtra("count", 0);
                    if (openProgress == null) {
                        openProgress = new OpeningProgressDialog(context);
                    }
                    openProgress.setMax(count);
                    openProgress.show();
                } else
                if (a.equals(DictionaryService.DICT_OPEN_FAILED) ||
                        a.equals(DictionaryService.OPENED_DICT)) {
                    if (openProgress != null) {
                        openProgress.incrementProgressBy(1);
                    }
                    if (a.equals(DictionaryService.DICT_OPEN_FAILED) && 
                            intent.getBooleanExtra("displayErrorMessage", true)) {
                        String file = intent.getStringExtra("file");
                        String reason = intent.getStringExtra("reason");
                        String msg = getResources().getString(R.string.toastDictFileFailed, file == null ? "" : file);
                        if (reason != null && !reason.equals("")) {
                            msg += ": " + reason;
                        }
                        Toast.makeText(BaseDictionaryActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                } else
                if (a.equals(DictionaryService.OPEN_FINISHED)) {
                    if (openProgress != null) {
                        openProgress.dismiss();
                        openProgress = null;
                    }
                    onDictionaryOpenFinished();
                }
            }
        };
        registerReceiver(broadcastReceiver, intentFilter);
    }

}