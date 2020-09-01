package model.data_structures;

public interface Lista<T extends Comparable<T>>
{
void addFirst(T dato);
void addLast(T dato);
void insertElement(T dato, int pos)throws Exception;
T removeFirst();
T removeLast();
T removePosition(int pos) throws Exception;
T getFirtsElement();
T giveLastElement() throws Exception;
T get(int pos) throws Exception;
int size();
boolean isEmpty();
int isPresent(T elemento) throws Exception;
void intercambiarInfo(int i, int j) throws Exception;
void cambiarInfo(int i, T elemento) throws Exception;












}
