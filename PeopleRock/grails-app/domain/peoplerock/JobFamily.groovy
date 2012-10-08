package peoplerock

class JobFamily {
    
    String jobFamilyName
    String description

    static constraints = {
        
        jobFamilyName(nullable:false, blank:false)
        description(nullable:false, blank:true)
    }
    
    String toString(){
        return "${jobFamilyName}"
    }
}
