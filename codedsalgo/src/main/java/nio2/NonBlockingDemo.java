package nio2;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NonBlockingDemo {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false); //make it non-blocking
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost" , 5050);

        serverSocketChannel.bind(inetSocketAddress);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            if (selector.select() == 0)
                continue;

            int key = selector.select();

            System.out.println("got key: "+key);

            Set<SelectionKey> selectionKeys =  selector.selectedKeys();

            for (SelectionKey selectionKey : selectionKeys) {
                if (selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                    socketChannel.read(byteBuffer);

                    while(byteBuffer.hasRemaining()){
                        byteBuffer.flip();
                        int i = 0;
                        while((i = byteBuffer.remaining()) >0) {
                            System.out.println((char)byteBuffer.get());
                        }

                        byteBuffer.clear();
                        socketChannel.read(byteBuffer);
                    }
                }
            }
        }

    }
}
