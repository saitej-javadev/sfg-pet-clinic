package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.PetType;

import java.util.Collection;

public interface CrudService<T,ID> {
    Collection<PetType> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}
