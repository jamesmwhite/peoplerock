package peoplerock

class JobPosition {
    
    JobFamily jobFamily
    Role role
    
    

    static constraints = {
        jobFamily(nullable:false,blank:false)
        role(nullable:false,blank:false)
    }
    
    String toString(){
        return "${jobFamily.jobFamilyName} - ${role.name}"
    }
}
