package java8.lambda;

/**
 * Created by codebug on 12/28/16.
 */
@FunctionalInterface
public interface HandlerHasParam<E> {

    public void handle(E e);


}
