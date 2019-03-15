package nio2;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferTest {

    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/swapnil.suhane/tmp/daraz.txt", "rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(48);

        int i = fileChannel.read(buffer);
        System.out.println("i: "+ i);
        while (i >0) {
            buffer.flip();

            while (buffer.hasRemaining()){
                System.out.print( (char)buffer.get());
            }

            //System.out.println("i -> " + i);
            buffer.clear();
            i = fileChannel.read(buffer);
        }

        randomAccessFile.close();
    }
}
