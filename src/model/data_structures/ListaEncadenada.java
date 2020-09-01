package model.data_structures;

public class ListaEncadenada <T extends Comparable<T>> implements Lista<T>
{
	private Node<T> listFirst;
	private int listSize;
	
	
	public ListaEncadenada ()
	{
	listFirst = null;
	}
	
	public ListaEncadenada (T item)
	{
	listFirst = new Node<T> (item) ;
	listSize = 1;
	}

	@Override
	public void addFirst(T dato) 
	{
		// TODO Auto-generated method stub
		Node <T> newHead = new Node<> (dato);
		newHead.setNextNode(listFirst);
		listFirst = newHead;
		listSize++;

		
	}

	@Override
	public void addLast(T dato) 
	{
		// TODO Auto-generated method stub
		Node <T> newNode = new Node<> (dato);
		if(listFirst == null) 
		{
		listFirst = newNode;
		}
		else 
		{
			Node <T> actual = listFirst;
			while(actual.getNext() != null) 
			{
			actual = actual.getNext();
			}
			actual.setNextNode(newNode);
		}
		listSize++;
		
	}

	@Override
	public void insertElement(T dato, int pos) throws Exception
	{
		// TODO Auto-generated method stub
		if(pos<1||pos>listSize)
		{
			throw new Exception("no se puede insertar en la posicion "+pos);
		}
		Node <T> actual= listFirst;
		int contador=1;
		boolean parar=false;
		
		if(pos==1)
		{
			this.addFirst(dato);
		}
		else if (pos==listSize)
		{
			this.addLast(dato);
		}
		else
		{
			while (actual.getNext()!= null&&!parar)
			{
				if(contador==pos-1)
				{
					Node<T> nuevo=new Node<>(dato);
					Node<T> reemplazar= actual.getNext();
					actual.setNextNode(nuevo);
					nuevo.setNextNode(reemplazar);
					parar=true;
				}
				contador++;
				actual=actual.getNext();
			}
			
			if(!parar)
			{
				throw new Exception("no se puede insertar en la posicion "+pos);
			}
			listSize++;
		}
		
		
		
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
	T respuesta= listFirst.getItem();
	Node<T> reemplazar=listFirst.getNext();
	listFirst=reemplazar;
	listSize--;
	return respuesta;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		T respuesta=null;
		Node<T> actual=listFirst;
		if(listSize==1)
		{
			respuesta=listFirst.getItem();
			listFirst=null;
			listSize--;
		}
		else
		{
			for (int i =2;i<listSize;i++)
			{
				actual=actual.getNext();
			}
			respuesta=actual.getNext().getItem();
			actual.setNextNode(null);
			listSize--;
		}
		return respuesta;
		
	}

	@Override
	public T removePosition(int pos) throws Exception
	{
		// TODO Auto-generated method stub
		T respuesta=null;
		if(pos<1||pos>listSize)
		{
			throw new Exception("no se puede insertar en la posicion "+pos);
		}
		Node <T> actual= listFirst;
		int contador=1;
		boolean parar=false;
		
		if(pos==1)
		{
			respuesta=listFirst.getItem();
			this.removeFirst();
		}
		
		else
		{
			while (actual.getNext()!= null&&!parar)
			{
				if(contador==pos-1)
				{
					respuesta=actual.getNext().getItem();
					Node<T>nuevo=actual.getNext().getNext();
					actual.setNextNode(nuevo);
					
					parar=true;
				}
				contador++;
				actual=actual.getNext();
			}
			if(!parar)
			{
				throw new Exception("no se puede insertar en la posicion "+pos);
			}
			listSize--;
		}
		
		return respuesta;
		
		
	}

	@Override
	public T getFirtsElement() {
		// TODO Auto-generated method stub
		return listFirst.getItem();
	}

	@Override
	public T giveLastElement() throws Exception 
	{
		// TODO Auto-generated method stub
		T respuesta=null;
		
		
			Node <T> actual = listFirst;
			while(actual.getNext() != null) 
			{
			actual = actual.getNext();
			}
			
			respuesta= actual.getItem();
			
			if(respuesta==null)
			{
				throw new Exception("la lista no esta inicializada");
			}
		return respuesta;
	}

	@Override
	public T get(int pos) throws Exception {
		// TODO Auto-generated method stub
		T respuesta=null;
		if(pos<1||pos>listSize)
		{
			throw new Exception("no se puede insertar en la posicion "+pos);
		}
		Node <T> actual= listFirst;
		int contador=1;
		boolean parar=false;
		
		if(pos==1)
		{
			respuesta=listFirst.getItem();
			
		}
		else if(pos==listSize)
		{
			respuesta=this.giveLastElement();
		}
		else
		{
			
			while (actual.getNext()!= null&&!parar)
			{
				if(contador==pos)
				{
					respuesta=actual.getItem();
					
					parar=true;
				}
				contador++;
				actual=actual.getNext();
			}
			if(!parar)
			{
				throw new Exception("no se puede insertar en la posicion "+pos);
			}
			
		}
		
		return respuesta;
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return listSize;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		boolean respuesta=true;
		if(listSize!=0)
		{
			respuesta=false;
		}
		return respuesta;
	}

	@Override
	public int isPresent(T elemento) throws Exception {
		// TODO Auto-generated method stub
		int rta = -1;
		Node<T> actual=listFirst;
		int contador=1;
		if(this.giveLastElement().compareTo(elemento)==0)
		{
			rta=listSize;
		}
		else 
		{
			while(actual.getNext()!=null && rta == -1)
			{
				
				if(elemento.compareTo(actual.getItem()) == 0)
				{
					rta = contador;
				}
				contador++;
				actual=actual.getNext();
			}
		}
		
		return rta; 
	}

	@Override
	public void intercambiarInfo(int i, int j) throws Exception 
	{
		// TODO Auto-generated method stub
		Node<T> actual=listFirst;
		Node<T> primero=null;
		Node<T> primerReemplazo=null;
		Node<T> primerSiguiente=null;
		Node<T> segundo=null;
		Node<T> segundoReemplazo=null;
		Node<T> segundoSiguiente=null;
		int contador=1;
		boolean parar1=false;
		boolean parar2=false;
		
		
		if(i<1||i>listSize||j<1||j>listSize)
		{
			throw new Exception("no se puede cambiar en la posicion ");
		}
		
		
		if(i==1)
		{
			primerReemplazo=listFirst;
			primerSiguiente=listFirst.getNext();
			parar1=true;
		}
		
		if(j==1)
		{
			segundoReemplazo=listFirst;
			segundoSiguiente=listFirst.getNext();
			parar2=true;
		}
		
		
		while (actual.getNext()!= null&&(!parar1||!parar2))
			{
				if(contador==i-1)
				{
					primero=actual;
					primerReemplazo=actual.getNext();
					primerSiguiente=primerReemplazo.getNext();
					
					parar1=true;
				}
				
				if(contador==j-1)
				{
					segundo=actual;
					segundoReemplazo=actual.getNext();
					segundoSiguiente=segundoReemplazo.getNext();
					
					parar2=true;
				}
				
				contador++;
				actual=actual.getNext();
			}
			
			if(!parar1||!parar1)
			{
				throw new Exception("no se puede insertar en la posicion ");
			}
		
		if(i==1)
		{
			listFirst=segundoReemplazo;
			segundoReemplazo.setNextNode(primerSiguiente);
			segundo.setNextNode(primerReemplazo);
			primerReemplazo.setNextNode(segundoSiguiente);
		}
		else if(j==1)
		{
			listFirst=primerReemplazo;
			primerReemplazo.setNextNode(segundoSiguiente);
			primero.setNextNode(segundoReemplazo);
			segundoReemplazo.setNextNode(primerSiguiente);
		}
		else
		{
			segundo.setNextNode(primerReemplazo);
			primerReemplazo.setNextNode(segundoSiguiente);
			primero.setNextNode(segundoReemplazo);
			segundoReemplazo.setNextNode(primerSiguiente);
		}
		
	}

	@Override
	public void cambiarInfo(int i, T elemento) throws Exception {
		// TODO Auto-generated method stub
		
		if(i<1||i>listSize)
		{
			throw new Exception("no se puede insertar en la posicion "+i);
		}
		Node <T> actual= listFirst;
		int contador=1;
		boolean parar=false;
		
		if(i==1)
		{
			listFirst.setItem(elemento);;
			
		}
		else if(i==listSize)
		{
			while(actual.getNext() != null) 
			{
			actual = actual.getNext();
			}
			actual.setItem(elemento);
		}
		else
		{
			
			while (actual.getNext()!= null&&!parar)
			{
				if(contador==i)
				{
					actual.setItem(elemento);
					
					parar=true;
				}
				contador++;
				actual=actual.getNext();
			}
			if(!parar)
			{
				throw new Exception("no se puede insertar en la posicion "+i);
			}
			
		}
		
		
		
	}



    
    
}
