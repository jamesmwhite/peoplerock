package peoplerock

class Role {

    String name
    String description
    
    static constraints = {
        
        name(inList:["Developer","Project Manager","People Leader","PMO","Tech Lead","Business Analyst","Architect","Senior Developer","Senior Business Analyst","Quality Assurance"])
        name unique:true        
        name(blank:false,nullable:false)
        description(nullable:false,blank:true)
        
    }
    
    String toString(){
        return "${name}"
    }
}
