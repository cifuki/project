public class test170 {
private void loadMore(int forPos) {
                if (loadingMoreForPos == forPos) {
                        return;
                }
                loadingMoreForPos = forPos;
                new Thread(new Runnable() {
                        public void run() {
                                loadBatch();
                                runOnUiThread(new Runnable() {
                                        public void run() {
                                                notifyDataSetChanged();
                                        }
                                });
                        }
                }).start();
        }

}