public class test62 {
void onDictionaryServiceConnected() {
                if (dictionaryService.getDictionaries().isEmpty()) {
                new Thread(new Runnable() {
                                public void run() {
                                        dictionaryService.openDictionaries();
                                        Log.d(TAG,
                                                        String.format("After openDictionaries() we have %d dictionaries",
                                                                        dictionaryService.getDictionaries().size()));
                                        if (dictionaryService.getDictionaries().isEmpty()) {
                                                runOnUiThread(new Runnable() {
                                                        public void run() {
                                                                Intent next = new Intent();
                                                                next.setAction(ACTION_NO_DICTIONARIES);
                                                                next.setClass(getApplicationContext(), DictionariesActivity.class);
                                                                Log.d(TAG, "No dictionaries, starting Dictionaries activity");
                                                                startActivity(next);
                                                                finish();
                                                        }
                                                });
                                        } else {
                                                runOnUiThread(new Runnable() {
                                                        public void run() {
                                                                onDictionaryServiceReady();
                                                        }
                                                });
                                        }
                                }
                        }).start();
                }
                else {
                        onDictionaryServiceReady();
                }
    }

}