package com.github.disc99.cache;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Minimal cache
 */
public class Cache<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = 1L;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final boolean DEFAULT_ACCESS_ORDER = true;
    private static final int DEFAULT_CACHE_SIZE = 1024;
    private final int cacheSize;
    
    public Cache() {
    	this(DEFAULT_CACHE_SIZE);
    }
    public Cache(int cacheSize) {
        super(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_ACCESS_ORDER);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(final Map.Entry<K,V> eldest) {
        return size() > cacheSize; 
    }
}
