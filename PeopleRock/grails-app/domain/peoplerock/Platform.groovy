package peoplerock

class Platform {

    String platformName
    String description
    
    static constraints = {
        platformName(nullable:false,blank:false)
        description(nullable:false,blank:true)
    }
    
    String toString(){
        return "${platformName}"
    }
}
