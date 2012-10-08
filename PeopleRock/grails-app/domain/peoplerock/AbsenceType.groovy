package peoplerock

class AbsenceType {
    
    String description    

    static constraints = {
        description(inList:["Sick","Compassionate","Maternity","Vacation","Unknown"])
        description(nullable:false,blank:false)
    }
    
    String toString(){
        return "${description}"
    }
}
