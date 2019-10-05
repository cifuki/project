public class test74 {
private void scandSDCard() {
        new Thread(new Runnable() {
            public void run() {
                dictionaryService.refresh();
                runOnUiThread(new Runnable() {
                    public void run() {
                        onDictionaryServiceReady();
                    }
                });
            }
        }).start();
    }

}