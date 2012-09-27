package peoplerock

class PersonCompetency {
    
    Competencies competency
    Level level

    static constraints = {
        competency(nullable:false,blank:false)
        level(nullable:false)
    }
    
    static belongsTo = [person:Person]
    
    String toString(){
        return "${competency.name}"
    }
}
