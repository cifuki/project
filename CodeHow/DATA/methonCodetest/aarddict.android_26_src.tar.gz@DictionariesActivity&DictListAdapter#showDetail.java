public class test87 {
private void showDetail(int position) {
            Intent i = new Intent(DictionariesActivity.this,
                    DictionaryInfoActivity.class);
            i.putExtra("volumeId", volumes.get(position).get(0).getId());
            startActivity(i);
        }

}