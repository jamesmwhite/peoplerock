package peoplerock

class TrainingAssignment {
    
    Employee employee
    Training training
    String notes

    static constraints = {
        employee(nullable:false,blank:false)
        training(nullable:false,blank:false)
        notes(nullable:false,blank:true)
    }
    
    String toString(){
        return "${employee} - ${training}"
    }
}
