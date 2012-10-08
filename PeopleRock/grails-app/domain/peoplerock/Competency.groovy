package peoplerock

class Competency {
    
    String description
    String shortDescription

    static constraints = {
        shortDescription(nullable:false,blank:false)        
        description(nullable:false,blank:true)        
    }
    
    String toString(){
        return "${shortDescription.substring(0,10)}"
    }
}
