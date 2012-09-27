package peoplerock

class Employee {
    
    Person person
    Role role
    

    static constraints = {
        person(nullable:false,blank:false)
        role(nullable:false,blank:false)
    }
    
    String toString(){
        return "${person.firstName},${person.lastName},${role.type}"
    }
}
