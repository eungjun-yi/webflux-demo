package com.example.demo;

import java.time.Duration;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import reactor.core.publisher.Flux;

class ItemRepository {
  private final Queue<Item> items = new ConcurrentLinkedQueue<>();

  public ItemRepository() {
    items.add(new Item("사과", 100));
    items.add(new Item("배", 200));
    items.add(new Item("참외", 50));
  }

  public Flux<Item> all() {
    return Flux.fromIterable(items).delayElements(Duration.ofSeconds(1));
  }

  public Flux<Boolean> save(Flux<Item> newItems) {
    return newItems.map(items::add);
  }
}
