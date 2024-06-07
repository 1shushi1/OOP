package dataBase.orm.embadded;

public class Skill {
    private String title;
    private int experience;
    public Skill(String title, int experience){
        this.title = title;
        this.experience = experience;
    }
    public String getTitle(){
        return title;
    }
    public int getExperience(){
        return experience;
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof Skill)){
            return false;
        }
        Skill skill = (Skill) o;
        return title.equals(skill.title) && experience == skill.experience;
    }
    @Override
    public int hashCode(){
        int hashCode = 13;
        hashCode += hashCode * 13 + title.hashCode();
        return hashCode * 13 + experience;
    }
}
