public class Blockchain {

    public static void printBlock(Block block) {
        System.out.println("Block:");
        System.out.println("ID: " + block.ID);
        System.out.println("Timestamp: " + block.timestamp);
        System.out.println("Hash of the previous block: " + block.previousHash);
        System.out.println("Hash of the block: " + block.hash + "\n");
    }

    public static void main(String[] args) {
        Block genesisBlock = new Block(0, "0");
        printBlock(genesisBlock);
        Block secondBlock = new Block(1, genesisBlock.hash);
        printBlock(secondBlock);
        Block thirdBlock = new Block(2, secondBlock.hash);
        printBlock(thirdBlock);
        Block fourthBlock = new Block(3, thirdBlock.hash);
        printBlock(fourthBlock);
        Block fifthBlock = new Block(4, fourthBlock.hash);
        printBlock(fifthBlock);
    }
}
