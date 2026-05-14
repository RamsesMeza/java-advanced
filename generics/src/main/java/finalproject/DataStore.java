package finalproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DataStore<T, K> {

  private final List<T> list = new ArrayList<>();
  private final Map<K, T> map = new HashMap<>();

  public void add(K key, T item) {
    Objects.requireNonNull(item, "No es valido");
    this.map.put(key, item);
    this.list.addLast(item);
  }

  public void remove(K key) {
    T item = this.map.remove(key);
    this.list.remove(item);
  }

  public T find(K key) {
    return this.map.get(key);
  }

  public List<T> getAll() {
    // return Collections.unmodifiableList(this.list); Lista que no se puede
    // modificar desde fuera
    return new ArrayList<>(this.list);
  }

  @Override
  public String toString() {
    return "\n DataStore \n list=" + list + " \n map=" + map + "";
  }

}
