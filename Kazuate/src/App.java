import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        int my_num = 37;
        int user_input_num = 0;
        Boolean is_correct = false;
        for(int i = 0; i < 5; i++){
            user_input_num = input_user_num();
            if(user_input_num == my_num){
                System.out.println("当たり");
                is_correct = true;
                break;
            }
            else{
                if(user_input_num > my_num){
                    System.out.println("大きいです");
                    if(user_input_num - my_num >= 20){
                        System.out.println("20以上差があります");
                    }
                }
                else{
                    System.out.println("小さい");
                    if(my_num - user_input_num >= 20){
                        System.out.println("20以上差があります");
                    }
                }
            }
        }
        if(!is_correct){
            System.out.println("不正解");
        }
    }

    public static int input_user_num(){
        int num;
        double num_d = -1;
        Boolean flag = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = ""; //読み取り用バッファ
        try{
            while(!(num_d >= 10 && num_d < 100) || flag){
                flag = false;
                System.out.println("好きな2桁の自然数をいれてください : ");
                line = br.readLine();
                num_d = Double.parseDouble(line); //文字列→整数
                System.out.println("入力された数字 " + line);
                if(num_d*10 - Math.floor(num_d)*10 != 0){
                    flag = true;
                }
            }
            num = (int)num_d;
        }catch(NumberFormatException e){//parseIntで変換できなかった場合
            System.out.println("Invalid input.\nyour number is 0.");
            num = 0;
        }catch(IOException e){
            System.out.println("IOException\nyour number is 0.");
            num = 0;
        }
        return num;
    }
}