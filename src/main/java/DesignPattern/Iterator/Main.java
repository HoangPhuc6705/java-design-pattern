package DesignPattern.Iterator;

public class Main {
    public static void main(String[] args) {
        ChannelCollectionImpl channelCollection = new ChannelCollectionImpl();
        channelCollection.addChannel(new Channel(10, "hehe"));
        channelCollection.addChannel(new Channel(11, "hehe"));
        channelCollection.addChannel(new Channel(12, "hehe"));
        channelCollection.addChannel(new Channel(13, "hehe"));
        channelCollection.addChannel(new Channel(15, "hehe"));
        channelCollection.addChannel(new Channel(17, "hehe"));
        ChannelIterator iterator = channelCollection.iterator("hehe");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
