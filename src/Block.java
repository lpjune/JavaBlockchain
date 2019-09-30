import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    public int ID;
    public long timestamp;
    private int nonce;

    // constructor
    public Block(int ID, String previousHash) {
        this.ID = ID;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        this.hash = makeHash();
    }

    // make hash
    public String makeHash() {
        String hash = StringUtil.applySha256(previousHash + Long.toString(timestamp) + Integer.toString(nonce) + ID);
        return hash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = makeHash();
        }
        System.out.println("Block Mined! : " + hash);
    }

    public void printBlock(Block b) {
        System.out.println("Block:");
        System.out.println("ID: " + b.getID());
        System.out.println("Timestamp: " + b.getTimestamp());
        System.out.println("Hash of the previous block: " + b.getPreviousHash());
        System.out.println("Hash of the block: " + b.getHash() + "\n");
    }

    public String getHash() {
        return this.hash;
    }

    public String getPreviousHash() {
        return this.previousHash;
    }

    public int getID() {
        return this.ID;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
