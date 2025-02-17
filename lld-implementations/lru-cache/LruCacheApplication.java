package com.practice.lru_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LruCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(LruCacheApplication.class, args);
		LRUCache lruCache = new LRUCache(2);
		System.out.println(lruCache.get(2));
		lruCache.put(2, 6);
		System.out.println(lruCache.get(1));
		lruCache.put(1, 5);
		lruCache.put(1, 2);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(2));
	}

}
