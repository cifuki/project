public class test139 {
Header(RandomAccessFile file) throws IOException {
        int specLen = 0;
        this.signature = file.readUTF8(4);
        specLen += 4;

        this.sha1sum = file.readUTF8(40);
        specLen += 40;

        this.version = file.readUnsignedShort();
        specLen += 2;

        this.uuid = file.readUUID();
        specLen += 16;

        this.volume = file.readUnsignedShort();
        specLen += 2;

        this.of = file.readUnsignedShort();
        specLen += 2;

        this.metaLength = file.readUnsignedInt();
        specLen += 4;

        this.indexCount = file.readUnsignedInt();
        specLen += 4;

        this.articleOffset = file.readUnsignedInt();
        specLen += 4;

        this.index1ItemFormat = file.readUTF8(4);
        specLen += 4;

        this.keyLengthFormat = file.readUTF8(2);
        specLen += 2;
        this.keyLengthSpec = this.keyLengthFormat.charAt(1);

        this.articleLengthFormat = file.readUTF8(2);
        specLen += 2;
        this.articleLengthSpec = this.articleLengthFormat.charAt(1);

        this.index1ItemSize = calcSize(this.index1ItemFormat);

        this.index1Offset = specLen + this.metaLength;
        this.index2Offset = this.index1Offset + this.indexCount*this.index1ItemSize;
        this.keyPointerSpec = this.index1ItemFormat.charAt(1);
        this.articlePointerSpec = this.index1ItemFormat.charAt(2);
    }

}