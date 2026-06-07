package DesignPattern.Iterator;

import java.util.ArrayList;
import java.util.List;

public class ChannelCollectionImpl implements ChannelCollection {

    private final List<Channel> channels;

    public ChannelCollectionImpl() {
        channels = new ArrayList<>();
    }


    public void addChannel(Channel c) {
        channels.add(c);
    }

    @Override
    public ChannelIterator iterator(String type) {
        return new ChannelIteratorImpl(channels);
    }
}
