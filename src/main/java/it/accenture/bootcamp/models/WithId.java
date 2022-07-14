package it.accenture.bootcamp.models;

public interface WithId<K> {
    K getId();
    void setId(K id);

}
