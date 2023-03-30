package CollectionFrameWork;

public class StudentsMarks implements Comparable<StudentsMarks>{
    private int maths;
    private int physics;
    @Override
    public String toString(){
        return "StudentsMarks[maths="+maths+",physics="+physics+"]";
    }
    public int getMath(){
        return maths;
    }
    public int getPhysics(){
        return physics;
    }
     public StudentsMarks(int maths,int physics){
        this.maths=maths;
        this.physics=physics;
     }
    @Override
    public int compareTo(StudentsMarks o) {
         return o.maths-this.maths;
    }

}
