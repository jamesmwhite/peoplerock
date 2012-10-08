package peoplerock

class CompetencyRate {

    String shortDescription
    String description
    
    static constraints = {
        shortDescription(nullable:false,blank:false)
        description(nullable:false,blank:true)
    }
    
    String toString(){
        return "${shortDescription}"
    }
}
