import java.time.LocalDateTime;
import java.util.Date;

public class ProfessorTest {
    public static void main(String[] args) {
        ProfessorList pList1 = new ProfessorList();
        pList1.addProfessor(new Professor("15", "han"));
        pList1.addProfessor(new Professor("7", "lee"));
        pList1.addProfessor(new Professor("6", "kim"));
        pList1.addProfessor(new Professor("9", "song"));
        pList1.addProfessor(new Professor("8", "park"));
        System.out.println(pList1.getById("8"));
        System.out.println(pList1.getById("10"));
        System.out.println(pList1.getByName("han"));
        System.out.println(pList1.professorAt(2));
        System.out.println(pList1.professorAt(8));
    }
}
class Professor{
    String name;
    String id;
    public Professor(){}
    public Professor(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String toString(){
        if(id.equals("") && name.equals("")){
            return "그런 교수는 없습니다.";
        }
        return "id:" + id + " " + "name:" + name;
    }
}
class ProfessorList{
    Professor[] professorList;
    int number;
    int idx = 0;
    public ProfessorList(){
        this.number = 20;
        this.professorList = new Professor[number];
    }
    public ProfessorList(int number){
        this.number = number;
        this.professorList = new Professor[number];
    }
    public void addProfessor(Professor professor){
        if(idx == number){
            System.out.println("리스트 길이 초과 리스트 크기 : " + number);
        }
        professorList[idx++] = professor;
    }
    public Professor getById(String id){
        for(int i=0; i<idx; i++){
            if(professorList[i].id.equals(id)){
                return professorList[i];
            }
        }
        return new Professor("", ""); //빈 professor 반환
    }
    public Professor getByName(String name){
        for(int i=0; i<idx; i++){
            if(professorList[i].name.equals(name)){
                return professorList[i];
            }
        }
        return new Professor("", ""); //빈 professor 반환
    }
    public Professor professorAt(int index){
        if(index >= this.number){
            return new Professor("", "");
        }
        if(professorList[index] != null) {
            return professorList[index];
        }else{
            return new Professor("", "");
        }
    }
}