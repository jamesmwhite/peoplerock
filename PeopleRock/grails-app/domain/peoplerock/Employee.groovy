package peoplerock

class Employee {
    
    String firstName
    String lastName
    String costCentre
    Date hireDate
    Employee employeeLeader
    String employmentStatus
    

    static constraints = {
        firstName(nullable:false,blank:false)
        lastName(nullable:false,blank:false)
        costCentre(nullable:false,blank:true)
        hireDate(nullable:false,blank:false)
        employeeLeader(nullable:true,blank:true)
        employmentStatus(inList:["Full","Probation","Contract","Left Company"])
        employmentStatus(nullable:false,blank:false)
    }
    
    String toString(){
        return "${firstName} ${lastName}"
    }
}
