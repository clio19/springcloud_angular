package com.htec.commonsmicroservices.commons.services;

import java.util.Optional;

public interface CommonService<E> {

    public Iterable<E> findAll();

    public Optional<E> findById(Long id);

    public E saveStudent(E entity);

    public void deleteById(Long id);
}