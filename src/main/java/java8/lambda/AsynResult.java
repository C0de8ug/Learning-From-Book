package java8.lambda;

/**
 * Created by codebug on 12/28/16.
 */
public class AsynResult {
    String result ;

    AsynResult(String result){
        this.result = result;
    }


    public String getResult(){
        return result;
    }

    @Override
    public String toString() {
        return  result;
    }
}
