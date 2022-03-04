package CWD;

public class Booth {
    private String Name;
    private int Count = 150;

    public Booth (){
        Name = "";
    }
    public void setName(String name) {
        Name = name;
    }
    public String getName() {
        return Name;
    }
    public void adding(int count) {
        Count = Count + count;
    }
    public int getCount() {
        return Count;
    }
}
