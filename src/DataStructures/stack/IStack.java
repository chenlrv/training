package DataStructures.stack;

public interface IStack <Item>{
    Item peek() throws Exception;
    Item pop() throws Exception;
    void push(Item item) throws Exception;
}
