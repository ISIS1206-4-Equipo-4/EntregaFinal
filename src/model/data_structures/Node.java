package model.data_structures;

public class Node <T>
{
	private Node<T> next;
	private T item;
	
	public Node (T item)
	{
	next = null;
	this.item = item;
	}
	
	public Node<T> getNext() 
	{
	return next;
	}
	
	public void setNextNode ( Node<T> next) 
	{
	this.next = next;
	}
	
	public T getItem()
	{
	return item;
	}
	
	public void setItem (T item)
	{
	this.item = item;
	}

}
