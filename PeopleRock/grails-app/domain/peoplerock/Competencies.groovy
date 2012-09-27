package peoplerock

class Competencies {
    
    String name
    
    static constraints = {
        name(nullable:false,blank:false)        
    }
    
    String toString(){
        return "${name}"
    }
}
