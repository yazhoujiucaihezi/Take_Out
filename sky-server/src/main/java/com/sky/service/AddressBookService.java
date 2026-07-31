package com.sky.service;

import com.sky.entity.AddressBook;

import java.util.List;

public interface AddressBookService {
    List<AddressBook> list(AddressBook addressBook);

    void add(AddressBook addressBook);

    void setDefault(AddressBook addressBook);

    AddressBook getDefault();

    void update(AddressBook addressBook);

    AddressBook getById(Long id);

    void delete(Long id);
}
