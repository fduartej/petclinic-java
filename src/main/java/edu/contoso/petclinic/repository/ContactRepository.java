package edu.contoso.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.contoso.petclinic.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

    
}
