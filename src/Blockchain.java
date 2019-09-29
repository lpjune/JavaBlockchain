import java.util.ArrayList;


public class Blockchain {

    public static ArrayList<Block> chain = new ArrayList<Block>();

    public static void printChain(ArrayList chain) {
        for(int i = 0; i < chain.size(); i++) {
            Block b = (Block) Blockchain.getChain().get(i);
            System.out.println("Block:");
            System.out.println("ID: " + b.getID());
            System.out.println("Timestamp: " + b.getTimestamp());
            System.out.println("Hash of the previous block: " + b.getPreviousHash());
            System.out.println("Hash of the block: " + b.getHash() + "\n");
        }
    }

    public static ArrayList<Block> getChain() {
        return chain;
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes:
        for(int i=1; i < chain.size(); i++) {
            currentBlock = chain.get(i);
            previousBlock = chain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.getHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        chain.add(new Block(0, "0"));
        chain.add(new Block(1, chain.get(chain.size()-1).hash));
        chain.add(new Block(2, chain.get(chain.size()-1).hash));
        chain.add(new Block(3, chain.get(chain.size()-1).hash));
        chain.add(new Block(4, chain.get(chain.size()-1).hash));
        printChain(getChain());
        isChainValid();
    }
}
