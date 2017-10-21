package Assignment6;

//class CustomException extends Exception {
//
//    //无参构造方法
//    public CustomException(){
//
//        super();
//    }
//
//    //有参的构造方法
//    public CustomException(String message){
//        super(message);
//
//    }
//
//    // 用指定的详细信息和原因构造一个新的异常
//    public CustomException(String message, Throwable cause){
//
//        super(message,cause);
//    }
//
//    //用指定原因构造一个新的异常
//    public CustomException(Throwable cause) {
//
//        super(cause);
//    }
//
//}
public class CustomException extends Exception{
    public CustomException(){

        super();
    }

    //有参的构造方法
    public CustomException(String message){
        super(message);

    }

    // 用指定的详细信息和原因构造一个新的异常
    public CustomException(String message, Throwable cause){

        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public CustomException(Throwable cause) {

        super(cause);
    }
    public void test2() {

        try{

            test1();

        }catch (CustomException e){

            RuntimeException exception  =  new RuntimeException(e);
            //exception.initCause(cause)
            throw  exception;
        }

    }

    public void test1() throws CustomException{

        throw new CustomException("我喝酒了");
    }
    // main方法
    public static void main(String[] args) throws CustomException {

        CustomException object =  new  CustomException();

        //try{

        object.test2();

        //}catch(Exception e){

        //e.printStackTrace();

        //}

    }
}
