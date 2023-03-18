public class permutation {
    public static void findpermutation(String str,String ans){
        if(str.length()==0){
            System.out.println();
        }
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            str=str.substring(0, i)+str.substring(i, i+1);
            findpermutation(str, ans+curr);
        }

    }
    public static void main(String[] args) {
        
    }
}
