package com.htec.commonsmicroservices.commons.services;

import java.util.Optional;

public interface CommonService<E> {

    public Iterable<E> findAll();

//    public Page<E> findAll(Pageable pageable );

    public Optional<E> findById(Long Id);

    public E save(E entity);

    public void deleteById(Long Id);
}
