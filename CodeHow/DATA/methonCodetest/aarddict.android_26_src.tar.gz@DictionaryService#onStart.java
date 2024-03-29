public class test108 {
@Override
        public void onStart(Intent intent, int startId) {
                String action = intent == null ? null : intent.getAction();
                if (action != null && action.equals(Intent.ACTION_VIEW)) {
                        final Uri data = intent.getData();
                        Log.d(TAG, "Path: " + data.getPath());
                        if (data != null && data.getPath() != null) {
                                Runnable r = new Runnable() {
                                        public void run() {
                                                Log.d(TAG, "opening: " + data.getPath());
                                                open(new File(data.getPath()));
                                        }
                                };
                                new Thread(r).start();
                        }
                }
        }

}