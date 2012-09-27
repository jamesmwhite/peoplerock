package peoplerock

class Skill {
    
    String name
    String details
    
    static constraints = {
        name(nullable:false,blank:false)
        details(nullable:true,blank:true)
    }
    
    String toString(){
        return "${name}"
    }
}
