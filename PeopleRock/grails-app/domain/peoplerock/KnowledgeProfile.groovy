package peoplerock

class KnowledgeProfile {

    Employee employee
    Skill skill
    Level level
    String note
    
    static constraints = {
        employee(nullable:false,blank:false)
        skill(nullable:false,blank:false)
        level(nullable:false,blank:false)
        note(nullable:false,blank:true)
    }
}
