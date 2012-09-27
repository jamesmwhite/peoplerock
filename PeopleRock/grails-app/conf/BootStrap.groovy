import peoplerock.Employee
import peoplerock.Person
import peoplerock.Role
import peoplerock.Skill
import peoplerock.Competencies
import peoplerock.Employee
import peoplerock.Person
import peoplerock.Role
import peoplerock.Skill
class BootStrap {

    def init = { servletContext ->
        
        def javaskill = new Skill(name:"Java",details:"1.6")                
        def flexskill = new Skill(name:"Flex")
        javaskill.save()
        flexskill.save()
        
        def lcomp = new Competencies(name:"Leadership")
        lcomp.save()
        
        def ccomp = new Competencies(name:"Communication")
        ccomp.save()
        
        def jimmy = new Person(firstName:"Larry",lastName:"King",nickName:"Lar")
        def jean = new Person(firstName:"Tom",lastName:"Jones")                
        jimmy.save()
        jean.save()
        
        
        
        def pm = new Role(type:"PM")
        def tl = new Role(type:"Tech Lead")
        pm = pm.save()
        tl = tl.save()
        
        
        def employeeJimmy = new Employee(person:jimmy,role:tl)                
        def employeeJean = new Employee(person:jean,role:pm)
        employeeJimmy.save()
        employeeJean.save()
    }
    def destroy = {
    }
}
