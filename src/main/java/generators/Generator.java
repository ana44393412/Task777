package generators;

public interface Generator<T> {

    void generateParams(int code);

    T buildResponse();

    T getResult(int code);
}
