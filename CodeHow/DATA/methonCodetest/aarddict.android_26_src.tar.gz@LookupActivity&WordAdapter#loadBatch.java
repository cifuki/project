public class test169 {
private void loadBatch() {
            int count = 0;
            while (results.hasNext() && count < 20) {
                count++;
                words.add(results.next());
            }
            displayMore = results.hasNext();
            itemCount = words.size();
        }

}