package peoplerock

enum Level {
    
    One(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5)
    
    int level
    
    Level(int level){
        this.level = level
    }


    static constraints = {
    }
}
