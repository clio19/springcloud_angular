package com.htec.commonsmicroservices.commons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public class CommonServiceImpl<E, R extends CrudRepository<E, Long>> implements CommonService<E> {

    @Autowired
    protected R studentRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Long Id) {
        return studentRepository.findById(Id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return studentRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long Id) {
        studentRepository.deleteById(Id);
    }

//    @Override
//    @Transactional(readOnly = true)
//    public Page<E> findAll(Pageable pageable) {
//        return (Page<E>) studentRepository.findAll(pageable);
//    }

}
