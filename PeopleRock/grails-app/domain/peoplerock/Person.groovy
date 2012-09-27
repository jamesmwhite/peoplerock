package peoplerock

class Person {

    String firstName
    String lastName
    String nickName
    
    
    
    static hasMany = [skills:Skill,trainingcourses:Training,competencies:PersonCompetency]
    
    
    static constraints = {
        firstName(nullable:false,blank:false)
        lastName(nullable:false,blank:false)
        nickName(nullable:true,blank:true)

    }
    
    String toString(){
        return getFullName()
    }
    
    String getFullName(){
        return firstName + " "+ lastName
    }
}
