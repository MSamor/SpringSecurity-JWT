package vip.maosi.entity.response;

public class RGenerator {
    public static ResEntity resSuccess(){
        return new ResEntity().setCode(DefinedCode.SUCCESS.getCode())
                                    .setMsg(DefinedCode.SUCCESS.getMsg());
    }

    /**
     * 第一个 表示是泛型
     * 第二个 表示返回的是T类型的数据
     * 第三个 限制参数类型为T
     * @param data
     * @param <T>
     * @return ResponseEntity<T>
     */
    public static <T> ResEntity resSuccessData(T data){
        return new ResEntity().setCode(DefinedCode.SUCCESS.getCode())
                .setMsg(DefinedCode.SUCCESS.getMsg())
                .setData(data);
    }

    public static ResEntity resFail(){
        return new ResEntity().setCode(DefinedCode.ERROR.getCode())
                .setMsg(DefinedCode.ERROR.getMsg());
    }

    public static ResEntity resFailData(String msg){
        return new ResEntity().setCode(DefinedCode.ERROR.getCode())
                .setMsg(msg);
    }
}
