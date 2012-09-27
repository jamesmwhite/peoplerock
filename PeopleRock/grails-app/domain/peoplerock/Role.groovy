package peoplerock

class Role {

    String type
    
    static constraints = {
        
        type(inList:["Team Member","PM","People Leader","PMO","Tech Lead"])
        type unique:true        
    }
    
    String toString(){
        return "${type}"
    }
}
