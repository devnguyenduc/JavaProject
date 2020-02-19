package com.coindesk.services.impl;

import com.coindesk.model.Customer;
import com.coindesk.model.Person;
import com.coindesk.module.Authentication;
import com.coindesk.repository.PersonRepository;
import com.coindesk.services.DeskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements DeskService<Person> {
    //
    private static PersonRepository personRepository;
    // Init Dependencies Person repository to PersonsService
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public String insert(Person temp){

        return success;
    }

    @Override
    public List<Person> search(){
        return personRepository.findAll();
    }

    @Override
    public Person searchID(long id){
        Person searchCustomer = personRepository.findById(id);
        return searchCustomer;
    }

    public Iterable<Person> searchByFirstName(String firstName){
        return personRepository.findByFirstName(firstName);
    }

    public Iterable<Person> searchByLastName(String lastName){
        return personRepository.findByLastName(lastName);
    }

    @Override
    public String change(long id, Person temp){
        Person findCustomerRepo = personRepository.findById(id);
        if(findCustomerRepo.getId() == temp.getId()){
            Person updateCustomer = new Person(findCustomerRepo);
            updateCustomer.set(temp);
            personRepository.save(updateCustomer);
            return success;
        }
        else{
            return fail;
        }
    }

    /*

    public void updateLaserDataByHumanId(String replacement, String humanId) {
        List<LaserData> laserDataByHumanId = laserDataRepository.findByHumanId(humanId);
        laserDataByHumanId.stream()
                .map(en -> en.setHumanId(replacement))
                .collect(Collectors.toList())
                .forEach(en -> laserDataRepository.save(en));
    }

     */

    @Override
    public String delete(long id, Person temp){
        Authentication _auth = new Authentication();
        boolean checkPerson = personRepository.existsById(id);
        Person findPersonRepo = personRepository.findById(id);
        if(findPersonRepo.getId() == temp.getId()){
            if(_auth.checkAuthentication()){
                personRepository.delete(temp);
                return success;
            }else{
                return fail;
            }
        }else{
            return fail;
        }
    }
}
