public class test227 {
private void init(RandomAccessFile file, File cacheDir, Map<UUID, Metadata> knownMeta) throws IOException, FormatException {
        this.file = file;
        this.header = new Header(file);
        this.assertFormat();
        this.sha1sum = header.sha1sum;
        if (knownMeta.containsKey(header.uuid)) {
                this.metadata = knownMeta.get(header.uuid);
        } else {
            String uuidStr = header.uuid.toString();
            File metadataCacheFile = new File(cacheDir, uuidStr);
            if (metadataCacheFile.exists()) {
                try {
                        long t0 = System.currentTimeMillis();
                        this.metadata = mapper.readValue(metadataCacheFile, Metadata.class);
                        knownMeta.put(header.uuid, this.metadata);
                        Log.d(TAG, format("Loaded meta for %s from cache in %s", metadataCacheFile.getName(), (System.currentTimeMillis() - t0)));
                }
                        catch(Exception e) {
                                Log.e(TAG, format("Failed to restore meta from cache file %s ", metadataCacheFile.getName()), e);
                        }
            }
            if (this.metadata == null) {
                long t0 = System.currentTimeMillis();
                byte[] rawMeta = new byte[(int) header.metaLength];
                file.read(rawMeta);
                String metadataStr = decompress(rawMeta);
                this.metadata = mapper.readValue(metadataStr, Metadata.class);
                Log.d(TAG, format("Read meta for in %s", header.uuid, (System.currentTimeMillis() - t0)));
                knownMeta.put(header.uuid, this.metadata);
                try {
                        mapper.writeValue(metadataCacheFile, this.metadata);
                        Log.d(TAG, format("Wrote metadata to cache file %s", metadataCacheFile.getName()));
                }
                catch (IOException e) {
                        Log.e(TAG, format("Failed to write metadata to cache file %s", metadataCacheFile.getName()), e);
                }
            }
        }
        initArticleURLTemplate();
    }

}