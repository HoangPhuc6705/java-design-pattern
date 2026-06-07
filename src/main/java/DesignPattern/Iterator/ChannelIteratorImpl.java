package DesignPattern.Iterator;

import java.util.ArrayList;
import java.util.List;

public class ChannelIteratorImpl implements ChannelIterator {

    private final List<Channel> channels;
    private String type;
    private int position = 0;

    public ChannelIteratorImpl(List<Channel> iter) {
        channels = iter;
    }

    @Override
    public boolean hasNext() {
        return position < channels.size();
    }

    @Override
    public Channel next() {
        return channels.get(position++);
    }
}
